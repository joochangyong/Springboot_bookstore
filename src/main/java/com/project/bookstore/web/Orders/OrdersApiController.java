package com.project.bookstore.web.Orders;

import com.project.bookstore.config.ApiResponse;

import com.project.bookstore.service.orders.OrdersService;

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

    private final OrdersService ordersService;


    @ApiOperation(value = "주문")
    @PostMapping("/ordersBuy")
    public ResponseEntity<?> ordersBuy(@RequestParam("isbn") String isbn, @RequestParam("orderAmount") Long basAmount,
            @RequestBody OrdersDto ordersDto, OrdersInfoDto ordersInfoDto) {
        ApiResponse result = null;

        try {
            ordersService.ordersInsert(ordersDto);
            ordersService.ordersInfoInsert(isbn, basAmount, ordersInfoDto);
            result = new ApiResponse(true, "성공", null);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
        
    }
    
}