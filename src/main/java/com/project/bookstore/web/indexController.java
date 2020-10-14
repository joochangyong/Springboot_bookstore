package com.project.bookstore.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@RequiredArgsConstructor
@Controller
@SessionAttributes("Users")
public class indexController {

    @GetMapping("/")
    public String index() { return "index"; }

    @GetMapping("/users/signIn")
    public String signIn() { return "signIn"; }

    @GetMapping("/users/mypage")
    public String mypage() { return "mypage"; }

    @GetMapping("/users/signUp")
    public String signUp() { return "signUp"; }

    @GetMapping("/books/bookSave")
    public String bookSave() { return "bookSave"; }
}
