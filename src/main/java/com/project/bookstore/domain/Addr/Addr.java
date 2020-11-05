package com.project.bookstore.domain.Addr;

import com.project.bookstore.domain.Users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Addr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addrCode;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    private String addrNic; //배송지 별명
    private String addrName; //수령인
    private Long addrZip; //우편번호
    private String addrBas; //기본주소
    private String addrDet; //상세주소

    @Builder
    public Addr (Users users, String addrNic, String addrName, Long addrZip, String addrBas, String addrDet){
        this.users = users;
        this.addrNic = addrNic;
        this.addrName = addrName;
        this.addrZip = addrZip;
        this.addrBas = addrBas;
        this.addrDet = addrDet;
    }
}
