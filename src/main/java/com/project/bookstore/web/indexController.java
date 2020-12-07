package com.project.bookstore.web;

import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.session.UsersInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class indexController {
    private final UsersInfo usersInfo;
    private final UsersService usersService;

    @GetMapping("/")
    public String index(String id, Model model) {
        model.addAttribute("usersInfo", usersService.findAllUsers(usersInfo));
        return "index";
    }
}
