package com.project.bookstore.web.Basket;

import com.project.bookstore.service.basket.BasketService;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.session.UsersInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BasketController {
    private final UsersService usersService;
    private final BasketService basketService;

    private final UsersInfo usersInfo;

    // 장바구니 정보
    @GetMapping("/basket")
    public String basket(Model model) {
        model.addAttribute("usersInfo", usersService.findAllUsers(usersInfo));
        model.addAttribute("basketInfo", basketService.basketInfo());
        return "Orders/basket";
    }
}
