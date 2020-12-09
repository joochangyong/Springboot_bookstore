package com.project.bookstore.service.orders;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
import com.project.bookstore.web.Orders.dto.OrdersInsertDto;

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

        ordersDto.setOrderDate(nowDate);
        ordersDto.setUsers(usersService.findByUsers(usersInfo));
        ordersDto.setCarVal(cardService.findCardNum(cardNum).getCardVal());
        ordersDto.setOrderZip(addrService.findAddrCode(addrCode).getAddrZip());
        ordersDto.setOrderBas(addrService.findAddrCode(addrCode).getAddrBas());
        ordersDto.setOrderDet(addrService.findAddrCode(addrCode).getAddrDet());
        ordersDto.setCardPeriod(cardService.findCardNum(cardNum).getCardPeriod());
        ordersRepository.save(ordersDto.toEntity());
    }

    @Transactional
    public void ordersInfoInsert(String isbn, Long basAmount, OrdersInsertDto ordersInsertDto) {
        OrdersMultiId ordersMultiId = new OrdersMultiId();

        ordersInsertDto.setBooks(booksService.findBookIsbn(isbn));
        ordersInsertDto.setOrderAmount(basAmount);
        
        //재고량
        Books books = new Books();
        books = booksService.findBookIsbn(isbn);
        Long updateBookSto = books.getBookSto() - basAmount;
        booksService.updateSto(isbn, updateBookSto);

        ordersMultiId.setIsbn(isbn);
        ordersMultiId.setOrderCode(ordersRepository.findByUsers_IdOrderByOrderCodeDesc(usersInfo.getUserId()).get(0).getOrderCode());
        ordersInsertDto.setOrdersMultiId(ordersMultiId);
        ordersInsertDto.setOrders(ordersRepository.findByUsers_IdOrderByOrderCodeDesc(usersInfo.getUserId()).get(0));
        ordersInfoRepository.save(ordersInsertDto.toEntity());
    }

    @Transactional
    public List<OrdersInfoDto> ordersInfo() {
        return ordersInfoRepository.findTop1ByOrders(ordersRepository.findByUsers_Id(usersInfo.getUserId())).stream()
            .map(OrdersInfoDto::new)
            .collect(Collectors.toList());
    }
}
