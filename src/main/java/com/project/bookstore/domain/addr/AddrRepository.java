//package com.project.bookstore.domain.addr;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface AddrRepository extends JpaRepository<Addr, Integer> {
//    @Query("SELECT a FROM Addr a WHERE a.addr_Code = ?1")
//    List<Addr> findAllAddr(String addr_Code);
//}
