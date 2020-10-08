package com.project.bookstore.domain.controller;

import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.web.dto.UsersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UsersApiController {

    private final UsersService usersService;

    @PostMapping("/api/v1/users")
    public String save (@RequestBody UsersDto requestDto) {

        return usersService.save(requestDto);
    }
}
