package com.project.bookstore.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class indexController {

//    @GetMapping("/")
//    public String index(Model model, @LoginUser SessionUser users) {
//        model.addAttribute("users", UsersService.findAllDesc());
//
//        if (users != null) {
//            model.addAttribute("name", users.getId());
//        }
//        return "index";
//    }
    @GetMapping("/")
    public String index() { return "index"; }

    @GetMapping("/users/signIn")
    public String signIn() { return "signIn"; }

    @GetMapping("/users/signUp")
    public String signUp() { return "signUp"; }
}
