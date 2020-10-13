package com.project.bookstore.web;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.web.dto.UsersInfoDto;
import com.project.bookstore.web.dto.UsersSignInDto;
import com.project.bookstore.web.dto.UsersSignUpDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Api(value = "회원", description = "로그인 관리", tags = { "회원" })
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController

public class UsersApiController {

    private final UsersService usersService;

    @ApiOperation(value = "회원가입")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "제목", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "content", value = "회원가입", required = true, dataType = "string", paramType = "query", defaultValue = ""), })
    @PostMapping("/api/users/signUp")
    public String save (@RequestBody UsersSignUpDto requestDto) {
        return usersService.save(requestDto);
    }

    @ApiOperation(value = "로그인")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "제목", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "content", value = "로그인", required = true, dataType = "string", paramType = "query", defaultValue = ""), })
    @PostMapping("/api/users/signIn")
    public ResponseEntity<?> signin(@RequestBody UsersSignInDto usersSignInDto, HttpSession session){
        ApiResponse result = null;
        try{
            System.out.println(usersSignInDto);
            UsersInfoDto userInfoDto = usersService.usersSign(usersSignInDto);
            if(userInfoDto != null) {
                result = new ApiResponse(true, "성공", userInfoDto);
                return ResponseEntity.ok().body(result);
            } else {
                result = new ApiResponse(false, "아이디나 비밀번호가 없습니다.", userInfoDto);
                return ResponseEntity.badRequest().body(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }
    public UsersInfoDto signIn(@RequestBody UsersSignInDto usersSignInDto) {
        return usersService.usersSign(usersSignInDto);
    }
}
