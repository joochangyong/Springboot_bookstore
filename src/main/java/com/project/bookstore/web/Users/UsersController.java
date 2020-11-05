package com.project.bookstore.web.Users;

import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.session.UsersInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class UsersController {
    private final UsersService usersService;
    private final UsersInfo usersInfo;
    //회원가입
    @GetMapping("/users/signUp")
    public String signUp() { return "Users/signUp"; }

    //로그인화면
    @GetMapping("/users/signIn")
    public String signIn() { return "Users/signIn"; }

    //마이페이지
//    @GetMapping("/users/mypage/{userid}")
//    public ResponseEntity<?> mypage(@PathVariable("userid") String id, Model model) {
//        model.addAttribute("userInfo", usersService.findAllUsers(id));
//        ApiResponse result = null;
//        try {
//            result = new ApiResponse(true, "성공", usersService.findAllUsers(id));
//            return ResponseEntity.ok().body(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//            result = new ApiResponse(false, e.getMessage(), null);
//            return ResponseEntity.badRequest().body(result);
//        }
//    }
    //마이페이지
    @GetMapping("/users/mypage/{id}")
    public String mypage(@PathVariable("id") String id, Model model) {
        model.addAttribute("userInfo", usersService.findAllUsers(usersInfo.getUserId()));
        return "Users/mypage";
    }

    //회원 정보 수정
    @GetMapping("/users/usersUpdate/{id}")
    public String usersUpdate(@PathVariable("id") String id, Model model) {
        model.addAttribute("userInfo", usersService.findAllUsers(usersInfo.getUserId()));
        return "Users/usersUpdate";
    }
}
