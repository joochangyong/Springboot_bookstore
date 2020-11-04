//package com.project.bookstore.domain.addr;
//
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Getter
//@NoArgsConstructor
//@Entity
//public class Addr {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int addr_Code;
//
//    @Column(length = 500, nullable = false)
//    private String users_id;
//    private String addr_Name;
//    private int addr_Zip;
//    private String addr_Bas;
//    private String addr_Det;
//    private int addr_Num;
//    private String addr_YN;
//    private String addr_Nic;
//    private String sec_Num;
//
//    @Builder
//    public Addr (String users_id, String addr_Name, int addr_Zip, String addr_Bas, String addr_Det, int addr_Num, String addr_YN, String addr_Nic, String sec_Num){
//        this.users_id = users_id;
//        this.addr_Name = addr_Name;
//        this.addr_Zip = addr_Zip;
//        this.addr_Bas = addr_Bas;
//        this.addr_Det = addr_Det;
//        this.addr_Num = addr_Num;
//        this.addr_YN = addr_YN;
//        this.addr_Nic = addr_Nic;
//        this.sec_Num = sec_Num;
//    }
//}
