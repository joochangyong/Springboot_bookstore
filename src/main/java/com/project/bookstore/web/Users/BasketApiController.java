package com.project.bookstore.web.Users;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.basket.BasketService;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.Users.dto.Basket.BasketCreateDto;
import com.project.bookstore.web.Users.dto.Basket.BasketInsertDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(value = "장바구니", description = "장바구니 관리", tags = { "장바구니" })
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController

public class BasketApiController {
    private final BasketService basketService;
    private final UsersInfo usersInfo;

    @ApiOperation(value = "장바구니")
    @PostMapping("/basket/{isbn}")
    public ResponseEntity<?> bookInsert (@PathVariable("isbn") String isbn, BasketCreateDto basketCreateDto, @RequestBody BasketInsertDto basketInsertDto) {
        ApiResponse result = null;
        try {
            if (basketService.basketFind(usersInfo) == false) {
                basketCreateDto.setUsers(basketService.findUsers(usersInfo));
                basketService.basketInsert(basketCreateDto);
            }
            
            result = new ApiResponse(true, "성공", basketService.basketinfoInsert(isbn, basketInsertDto, usersInfo));
            System.out.println("수량확인");
            System.out.println(basketInsertDto.getBasAmount());
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }
} 