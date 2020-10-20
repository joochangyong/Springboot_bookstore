package com.project.bookstore.web.Users;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class UsersController {
    private final UsersService usersService;
    //회원가입
    @GetMapping("/users/signUp")
    public String signUp() { return "Users/signUp"; }

    //로그인화면
    @GetMapping("/users/signIn")
    public String signIn() { return "Users/signIn"; }

    //마이페이지
    @GetMapping("/users/mypage/{id}")
    public ResponseEntity<?> mypage(@PathVariable("id") String id) {
        ApiResponse result = null;
        try {
            result = new ApiResponse(true, "성공", usersService.findAllUsers(id));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }
//    public String mypage() { return "Users/mypage"; }
}
