package com.project.bookstore.service.users;

import com.project.bookstore.domain.Addr.Addr;
import com.project.bookstore.domain.Addr.AddrRepository;
import com.project.bookstore.domain.Users.Users;
import com.project.bookstore.domain.Users.UsersRepository;
import com.project.bookstore.session.UsersInfo;
import com.project.bookstore.web.Users.dto.Addr.AddrInfoDto;
import com.project.bookstore.web.Users.dto.Addr.AddrSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AddrService {
    private final AddrRepository addrRepository;
    private final UsersRepository usersRepository;

    @Transactional
    public Users findUsers(UsersInfo usersInfo) {
        return usersRepository.findById(usersInfo.getUserId()).get();
    }
    
    //정보 불러오기
    @Transactional
    public List<AddrInfoDto> findByUsers_Id(String id) {
        return addrRepository.findByUsers_Id(id).stream()
                .map(AddrInfoDto::new)
                .collect(Collectors.toList());
    }

    //주소등록
    @Transactional
    public Long addrSave(AddrSaveDto addrSaveDto) {
        return addrRepository.save(addrSaveDto.toEntity()).getAddrZip();
    }

    //주소 삭제
    @Transactional
    public void delete (Long addrCode) {
        Addr addr = addrRepository.findById(addrCode).orElseThrow(() -> new IllegalArgumentException("삭제안됨"));
        addrRepository.delete(addr);
    }
}
