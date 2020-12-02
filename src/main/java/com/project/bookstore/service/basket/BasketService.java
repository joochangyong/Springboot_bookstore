package com.project.bookstore.service.basket;

import com.project.bookstore.domain.Users.UsersRepository;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.Users.dto.Basket.BasketCreateDto;
import com.project.bookstore.web.Users.dto.Basket.BasketInsertDto;
import com.project.bookstore.domain.Users.Users;
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

    //책 장바구니 담기
    @Transactional
    public Long basketinfoInsert(String isbn, BasketInsertDto basketInsertDto, UsersInfo usersInfo) {
        BasketMultiId basketMultiId = new BasketMultiId();
        basketMultiId.setBasNum(basketRepository.findByUsers_Id(usersInfo.getUserId()).getBasNum());
        basketMultiId.setIsbn(isbn);
        basketInsertDto.setBasketMultiId(basketMultiId);
        basketInsertDto.setBasket(basketRepository.findByUsers_Id(usersInfo.getUserId()));
        basketInsertDto.setBooks(booksRepository.findById(isbn).get());
        return basketInfoRepository.save(basketInsertDto.toEntity()).getBasketMultiId().getBasNum();
    }
}