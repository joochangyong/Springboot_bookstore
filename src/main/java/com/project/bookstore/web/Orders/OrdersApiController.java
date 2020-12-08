package com.project.bookstore.web.Orders;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.domain.Books.Books;
import com.project.bookstore.domain.Users.Users;
import com.project.bookstore.service.books.BooksService;
import com.project.bookstore.service.orders.OrdersService;
import com.project.bookstore.service.users.AddrService;
import com.project.bookstore.service.users.CardService;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.Orders.dto.OrdersDto;
import com.project.bookstore.web.Orders.dto.OrdersInfoDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "주문", description = "주문", tags = { "주문" })
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class OrdersApiController {
    private final UsersInfo usersInfo;
    private final UsersService usersService;
    private final AddrService addrService;
    private final CardService cardService;
    private final BooksService booksService;
    private final OrdersService ordersService;

    @ApiOperation(value = "주문")
    @PostMapping("/ordersBuy")
    public ResponseEntity<?> ordersBuy(@RequestParam("isbn") String isbn, @RequestParam("orderAmount") Long basAmount,
            @RequestBody OrdersDto ordersDto, OrdersInfoDto ordersInfoDto) {
        ApiResponse result = null;
        Long addrCode = ordersDto.getAddrCode();
        String cardNum = ordersDto.getCardNum();
        
        ordersDto.setUsers((Users) usersService.findAllUsers(usersInfo));
        ordersDto.setOrderZip(addrService.findAddrCode(addrCode).getAddrZip());
        ordersDto.setOrderBas(addrService.findAddrCode(addrCode).getAddrBas());
        ordersDto.setOrderDet(addrService.findAddrCode(addrCode).getAddrDet());
        ordersDto.setCardPeriod(cardService.findCardNum(cardNum).getCardPeriod());
        ordersDto.setCarVal(cardService.findCardNum(cardNum).getCardVal());

        ordersInfoDto.setBooks(booksService.findBookIsbn(isbn));
        ordersInfoDto.setOrderAmount(basAmount);
        
        //재고량
        Books books = new Books();
        books = (Books) booksService.findBybookInfo(isbn);
        Long updateBookSto = books.getBookSto() - basAmount;
        booksService.updateSto(isbn, updateBookSto);

        try {
            ordersService.ordersInsert(ordersDto);
            ordersService.ordersInfoInsert(isbn, ordersInfoDto);
            result = new ApiResponse(true, "성공", null);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
        
    }
    
}