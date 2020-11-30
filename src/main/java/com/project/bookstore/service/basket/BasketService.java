package com.project.bookstore.service.basket;

import com.project.bookstore.domain.Users.UsersRepository;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.Users.dto.Basket.BasketCreateDto;
import com.project.bookstore.domain.Users.Users;
import com.project.bookstore.domain.Basket.BasketRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BasketService {
    private final UsersRepository usersRepository;
    private final BasketRepository basketRepository;

    @Transactional(readOnly = true)
    public Users findUsers(UsersInfo usersInfo) {
        return usersRepository.findById(usersInfo.getUserId()).get();
    }

    // 장바구니 확인
    @Transactional
    public Boolean basketFind(UsersInfo usersInfo) {
        if (basketRepository.findByUsers_Id(usersInfo.getUserId()) == null) {
            return false;
        } else {
            return true;
        }
    }

    // 장바구니 생성
    @Transactional
    public Long basketInsert(BasketCreateDto basketCreateDto) {
        return basketRepository.save(basketCreateDto.toEntity()).getBasNum();
    }
}