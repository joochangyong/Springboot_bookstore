package com.project.bookstore.web.Users;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.Users.dto.Users.UsersInfoDto;
import com.project.bookstore.web.Users.dto.Users.UsersSignInDto;
import com.project.bookstore.web.Users.dto.Users.UsersSignUpDto;
import com.project.bookstore.web.Users.dto.Users.UsersUpdateDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "회원", description = "회원 관리", tags = { "회원" })
@RequestMapping("/api/users")
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController

public class UsersApiController {
    private final UsersService usersService;
    private final UsersInfo usersInfo;

    @ApiOperation(value = "회원가입")
    @PostMapping("/signUp")
    public ResponseEntity<?> save (@RequestBody UsersSignUpDto requestDto) {
        ApiResponse result = null;
        UsersInfoDto idCheck = new UsersInfoDto(usersService.findById(requestDto.getId()));
        if(idCheck.getId() == null){
            try {
                if(requestDto.getId() != "" && requestDto.getPw() != "" && requestDto.getName() != "") {
                    result = new ApiResponse(true, "성공", usersService.save(requestDto));
                    return ResponseEntity.ok().body(result);
                } else {
                    result = new ApiResponse(false, "실패", null);
                    return ResponseEntity.badRequest().body(result);
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = new ApiResponse(false, e.getMessage(), null);
                return ResponseEntity.badRequest().body(result);
            }
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "로그인")
    @PostMapping("/signIn")
    public ResponseEntity<?> signin(@RequestBody UsersSignInDto usersSignInDto){
        ApiResponse result = null;
        try{
            if(usersService.usersSign(usersSignInDto) != null) {
                result = new ApiResponse(true, "성공", usersService.usersSign(usersSignInDto));
                usersInfo.setUserId(usersSignInDto.getId());
                return ResponseEntity.ok().body(result);
            } else {
                result = new ApiResponse(false, "아이디나 비밀번호가 없습니다.", usersService.usersSign(usersSignInDto));
                return ResponseEntity.badRequest().body(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }
    @ApiOperation(value = "로그아웃")
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        ApiResponse result = null;
        usersInfo.setUserId(null);
        result = new ApiResponse(true, "성공", usersInfo.getUserId());
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "회원정보 수정")
    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody UsersUpdateDto usersUpdateDto) {
        ApiResponse result = null;
        try {
            result = new ApiResponse(true, "성공", usersService.Update(id, usersUpdateDto));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }
}