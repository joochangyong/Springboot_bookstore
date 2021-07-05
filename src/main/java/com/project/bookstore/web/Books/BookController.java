package com.project.bookstore.web.Books;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.books.BooksService;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.session.UsersInfo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BookController {
    private final BooksService booksService;
    private final UsersService usersService;
    private final UsersInfo usersInfo;

    // 책등록
    @GetMapping("/books/bookSave")
    public String bookSave(Model model) {
        model.addAttribute("usersInfo", usersService.findAllUsers(usersInfo));
        return "Book/bookSave";
    }

    // 책리스트
    @GetMapping("/books/bookList")
    public String bookList(Model model) {
        if (usersInfo.getUserId() != null) {
            if (usersInfo.getUserId().equals("master")) {
                model.addAttribute("master", usersService.findAllUsers(usersInfo));
            }
        }
        model.addAttribute("usersInfo", usersService.findAllUsers(usersInfo));
        model.addAttribute("bookList", booksService.findAllBooks());
        return "Book/bookList";
    }

    // 책 상세정보
    @GetMapping("/books/bookInfo/{isbn}")
    public String bookInfo(@PathVariable("isbn") String isbn, Model model) {
        if (usersInfo.getUserId() != null) {
            if (usersInfo.getUserId().equals("master")) {
                model.addAttribute("master", usersService.findAllUsers(usersInfo));
            }
        }
        model.addAttribute("usersInfo", usersService.findAllUsers(usersInfo));
        model.addAttribute("bookInfo", booksService.findBybookInfo(isbn));
        return "Book/bookInfo";
    }

    // 책 정보 수정
    @GetMapping("/books/bookUpdate/{isbn}")
    public String bookUpdate(@PathVariable("isbn") String isbn, Model model) {
        model.addAttribute("usersInfo", usersService.findAllUsers(usersInfo));
        model.addAttribute("bookInfo", booksService.findBybookInfo(isbn));
        return "Book/bookUpdate";
    }

    // 책정보
    @GetMapping("/books/bookInfo")
    public ResponseEntity<?> bookInfo() {
        ApiResponse result = null;
        try {
            result = new ApiResponse(true, "성공", booksService.findAllBooks());
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }
}
