package com.project.bookstore.service.orders;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;

import com.project.bookstore.domain.Orders.OrdersRepository;
import com.project.bookstore.domain.OrdersInfo.OrdersInfoRepository;
import com.project.bookstore.domain.OrdersInfo.OrdersMultiId;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.Orders.dto.OrdersDto;
import com.project.bookstore.web.Orders.dto.OrdersInfoDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrdersInfoRepository ordersInfoRepository;
    private final UsersInfo usersInfo;

    @Transactional
    public void ordersInsert(OrdersDto ordersDto) {
        ordersRepository.save(ordersDto.toEntity());
    }

    @Transactional
    public void ordersInfoInsert(String isbn, OrdersInfoDto ordersInfoDto) {
        OrdersMultiId ordersMultiId = new OrdersMultiId();
        ordersMultiId.setIsbn(isbn);
        ordersMultiId.setOrderCode(ordersRepository.findByUsers_Id(usersInfo.getUserId()).get(0).getOrderCode());
        ordersInfoDto.setOrdersMultiId(ordersMultiId);
        ordersInfoDto.setOrders(ordersRepository.findByUsers_Id(usersInfo.getUserId()).get(0));
        ordersInfoRepository.save(ordersInfoDto.toEntity());
    }
}
