package com.project.bookstore.service.basket;

import com.project.bookstore.domain.Users.UsersRepository;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.Users.dto.Basket.BasketCreateDto;
import com.project.bookstore.web.Users.dto.Basket.BasketInfoDto;
import com.project.bookstore.web.Users.dto.Basket.BasketInsertDto;
import com.project.bookstore.domain.Users.Users;

import java.util.List;
import java.util.stream.Collectors;

import com.project.bookstore.domain.Basket.BasketRepository;
import com.project.bookstore.domain.BasketInfo.BasketInfoRepository;
import com.project.bookstore.domain.BasketInfo.BasketMultiId;
import com.project.bookstore.domain.Books.BooksRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BasketService {
    private final UsersRepository usersRepository;
    private final BasketRepository basketRepository;
    private final BooksRepository booksRepository;
    private final BasketInfoRepository basketInfoRepository;
    private final UsersInfo usersInfo;

    @Transactional(readOnly = true)
    public Users findUsers() {
        return usersRepository.findById(usersInfo.getUserId()).get();
    }

    // 장바구니 확인
    @Transactional
    public Boolean basketFind() {
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

    //책 장바구니 담기
    @Transactional
    public Long basketInfoInsert(String isbn, BasketInsertDto basketInsertDto) {
        BasketMultiId basketMultiId = new BasketMultiId();
        basketMultiId.setBasNum(basketRepository.findByUsers_Id(usersInfo.getUserId()).getBasNum());
        basketMultiId.setIsbn(isbn);
        basketInsertDto.setBasketMultiId(basketMultiId);
        basketInsertDto.setBasket(basketRepository.findByUsers_Id(usersInfo.getUserId()));
        basketInsertDto.setBooks(booksRepository.findById(isbn).get());
        return basketInfoRepository.save(basketInsertDto.toEntity()).getBasketMultiId().getBasNum();
    }

    //장바구니 정보
    @Transactional
    public List<BasketInfoDto> basketInfo() {
        return basketInfoRepository.findByBasket(basketRepository.findByUsers_Id(usersInfo.getUserId())).stream()
                .map(BasketInfoDto::new)
                .collect(Collectors.toList());
    }
}