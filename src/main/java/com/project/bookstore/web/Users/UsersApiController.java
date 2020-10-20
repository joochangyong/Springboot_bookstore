package com.project.bookstore.web.Users;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.web.Users.dto.UsersInfoDto;
import com.project.bookstore.web.Users.dto.UsersSignInDto;
import com.project.bookstore.web.Users.dto.UsersSignUpDto;
import com.project.bookstore.web.Users.dto.UsersUpdateDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Api(value = "회원", description = "회원 관리", tags = { "회원" })
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
    public ResponseEntity<?> save (@RequestBody UsersSignUpDto requestDto) {
        ApiResponse result = null;
        UsersInfoDto idCheck = new UsersInfoDto(usersService.findById(requestDto.getId()));
        if(idCheck.getId() == null){
            try {
                if(requestDto.getId() != "") {
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "제목", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "content", value = "로그인", required = true, dataType = "string", paramType = "query", defaultValue = ""), })
    @PostMapping("/api/users/signIn")
    public ResponseEntity<?> signin(@RequestBody UsersSignInDto usersSignInDto, HttpSession session){
        ApiResponse result = null;
        try{
            System.out.println(usersSignInDto);
            UsersInfoDto usersInfoDto = usersService.usersSign(usersSignInDto);
            if(usersInfoDto != null) {
                result = new ApiResponse(true, "성공", usersInfoDto);
                return ResponseEntity.ok().body(result);
            } else {
                result = new ApiResponse(false, "아이디나 비밀번호가 없습니다.", usersInfoDto);
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

    @ApiOperation(value = "회원정보 수정")
    @PutMapping("api/users/update/{id}")
    public ResponseEntity update(@PathVariable("id") String id, @RequestBody UsersUpdateDto usersUpdateDto) {
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