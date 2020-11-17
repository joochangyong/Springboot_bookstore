package com.project.bookstore.web.Users.dto.Addr;

import com.project.bookstore.domain.Addr.Addr;
import com.project.bookstore.domain.Users.Users;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddrSaveDto {
    private String addrNic;
    private String addrName;
    private Long addrZip;
    private String addrBas;
    private String addrDet;
    private Users users;

    @Builder
    public AddrSaveDto (String addrNic, String addrName, Long addrZip, String addrBas, String addrDet, Users users){
        this.addrNic = addrNic;
        this.addrName = addrName;
        this.addrZip = addrZip;
        this.addrBas = addrBas;
        this.addrDet = addrDet;
    }

    public Addr toEntity() {
        return Addr.builder()
                .addrNic(addrNic)
                .addrName(addrName)
                .addrZip(addrZip)
                .addrBas(addrBas)
                .addrDet(addrDet)
                .users(users)
                .build();
    }
}
