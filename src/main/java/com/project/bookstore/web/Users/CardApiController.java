package com.project.bookstore.web.Users;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.CardService;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.Users.dto.Card.CardSaveDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Api(value = "카드", description = "카드 관리", tags = { "카드" })
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController

public class CardApiController {
    private final CardService cardService;
    private final UsersInfo usersInfo;
    
    @ApiOperation(value = "카드등록")
    @PostMapping("/api/cardSave/{id}")
    public ResponseEntity<?> save (@RequestBody CardSaveDto cardSaveDto) {
        ApiResponse result = null;
        try {
            if(cardSaveDto.getCardNum() != null) {
				cardSaveDto.setUsers(cardService.findUsers(usersInfo));
                result = new ApiResponse(true, "성공", cardService.cardSave(cardSaveDto));
                return ResponseEntity.ok().body(result);
            } else {
                result = new ApiResponse(false, "실패", null);
                return ResponseEntity.badRequest().body(result);
            }
        }catch (Exception e){
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    //카드 삭제
    @PostMapping("/cardDelete/{cardNum}")
    public RedirectView delete(@PathVariable("cardNum") String cardNum) {
        cardService.delete(cardNum);
        return new RedirectView("/users/mypage");
    }
}
