package com.project.bookstore.service.orders;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import com.project.bookstore.domain.Books.Books;
import com.project.bookstore.domain.Orders.OrdersRepository;
import com.project.bookstore.domain.OrdersInfo.OrdersInfoRepository;
import com.project.bookstore.domain.OrdersInfo.OrdersMultiId;
import com.project.bookstore.service.books.BooksService;
import com.project.bookstore.service.users.AddrService;
import com.project.bookstore.service.users.CardService;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.Orders.dto.OrdersDto;
import com.project.bookstore.web.Orders.dto.OrdersInfoDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrdersInfoRepository ordersInfoRepository;
    private final UsersService usersService;
    private final AddrService addrService;
    private final CardService cardService;
    private final BooksService booksService;
    private final UsersInfo usersInfo;

    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String nowDate = format.format(now);

    @Transactional
    public void ordersInsert(OrdersDto ordersDto) {
        Long addrCode = ordersDto.getAddrCode();
        String cardNum = ordersDto.getCardNum();

        ordersDto.setUsers(usersService.findByUsers(usersInfo));
        ordersDto.setOrderDate(nowDate);
        ordersDto.setOrderZip(addrService.findAddrCode(addrCode).getAddrZip());
        ordersDto.setOrderBas(addrService.findAddrCode(addrCode).getAddrBas());
        ordersDto.setOrderDet(addrService.findAddrCode(addrCode).getAddrDet());
        ordersDto.setCardPeriod(cardService.findCardNum(cardNum).getCardPeriod());
        ordersDto.setCarVal(cardService.findCardNum(cardNum).getCardVal());
        ordersRepository.save(ordersDto.toEntity());
    }

    @Transactional
    public void ordersInfoInsert(String isbn, Long basAmount, OrdersInfoDto ordersInfoDto) {
        OrdersMultiId ordersMultiId = new OrdersMultiId();

        ordersInfoDto.setBooks(booksService.findBookIsbn(isbn));
        ordersInfoDto.setOrderAmount(basAmount);
        
        //재고량
        Books books = new Books();
        books = booksService.findBookIsbn(isbn);
        Long updateBookSto = books.getBookSto() - basAmount;
        booksService.updateSto(isbn, updateBookSto);

        ordersMultiId.setIsbn(isbn);
        ordersMultiId.setOrderCode(ordersRepository.findByUsers_IdOrderByOrderCodeDesc(usersInfo.getUserId()).get(0).getOrderCode());
        ordersInfoDto.setOrdersMultiId(ordersMultiId);
        ordersInfoDto.setOrders(ordersRepository.findByUsers_IdOrderByOrderCodeDesc(usersInfo.getUserId()).get(0));
        ordersInfoRepository.save(ordersInfoDto.toEntity());
    }
}
