package com.project.bookstore.web.Users.dto.Addr;

import com.project.bookstore.domain.Addr.Addr;
import com.project.bookstore.domain.Users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddrInfoDto {
    private Long addrCode;
    private String addrNic;
    private String addrName;
    private Long addrZip;
    private String addrBas;
    private String addrDet;
    private Users users;

    public AddrInfoDto(Addr entity) {
        this.addrCode = entity.getAddrCode();
        this.addrNic = entity.getAddrNic();
        this.addrName = entity.getAddrName();
        this.addrZip = entity.getAddrZip();
        this.addrBas = entity.getAddrBas();
        this.addrDet = entity.getAddrDet();
        this.users = entity.getUsers();
    }
}
