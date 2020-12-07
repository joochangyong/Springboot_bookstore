package com.project.bookstore.web.Orders;

import com.project.bookstore.service.books.BooksService;
import com.project.bookstore.service.users.AddrService;
import com.project.bookstore.service.users.CardService;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.session.UsersInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OrdersController {
    private final UsersService usersService;
    private final BooksService booksService;
    private final CardService cardService;
    private final AddrService addrService;
    private final UsersInfo usersInfo;


    // 주문페이지
    @GetMapping("/orders")
    public String order(@RequestParam("isbn") String isbn, @RequestParam("basAmount") Long basAmount, String id, Model model) {
        model.addAttribute("usersInfo", usersService.findAllUsers(usersInfo));
        model.addAttribute("bookInfo", booksService.findBybookInfo(isbn));
        model.addAttribute("addrInfo", addrService.findByUsers_Id(usersInfo));
        model.addAttribute("cardInfo", cardService.findByUsers_Id(usersInfo));
        model.addAttribute("orderAmount", basAmount);

        return "Orders/Orders";
    }
}
