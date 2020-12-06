package com.project.bookstore.web.Users;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.AddrService;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.Users.dto.Addr.AddrSaveDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Api(value = "주소", description = "주소 관리", tags = { "주소" })
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController

public class AddrApiController {
    private final AddrService addrService;
    private final UsersInfo usersInfo;

    @ApiOperation(value = "주소등록")
    @PostMapping("/api/addrSave/{id}")
    public ResponseEntity<?> save(@RequestBody AddrSaveDto addrSaveDto) {
        ApiResponse result = null;
        try {
            if (addrSaveDto.getAddrZip() != null) {
                addrSaveDto.setUsers(addrService.findUsers(usersInfo));
                result = new ApiResponse(true, "성공", addrService.addrSave(addrSaveDto));
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
    }

    // 배송지 삭제
    @PostMapping("/addrDelete/{addrCode}")
    public RedirectView delete(@PathVariable("addrCode") Long addrCode) {
        addrService.delete(addrCode);
        return new RedirectView("/users/mypage");
    }
}
