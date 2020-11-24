package com.project.bookstore.service.users;

import com.project.bookstore.domain.Cards.Cards;
import com.project.bookstore.domain.Cards.CardsRepository;
import com.project.bookstore.domain.Users.Users;
import com.project.bookstore.domain.Users.UsersRepository;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.Users.dto.Card.CardInfoDto;
import com.project.bookstore.web.Users.dto.Card.CardSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CardService {
    private final CardsRepository cardsRepository;
    private final UsersRepository usersRepository;

    @Transactional
    public Users findUsers(UsersInfo usersInfo) {
        return usersRepository.findById(usersInfo.getUserId()).get();
    }
    
    //정보 불러오기
    @Transactional
    public List<CardInfoDto> findByUsers_Id(String id) {
        return cardsRepository.findByUsers_Id(id).stream()
                .map(CardInfoDto::new)
                .collect(Collectors.toList());
    }

    //카드등록
    @Transactional
    public String cardSave(CardSaveDto cardSaveDto) {
        return cardsRepository.save(cardSaveDto.toEntity()).getCardNum();
    }

    //카드 삭제
    @Transactional
    public void delete (String cardNum) {
        System.out.println("---------------------");
        System.out.println(cardNum);
        Cards cards = cardsRepository.findById(cardNum).orElseThrow(() -> new IllegalArgumentException("삭제안됨"));
        cardsRepository.delete(cards);
    }
}
