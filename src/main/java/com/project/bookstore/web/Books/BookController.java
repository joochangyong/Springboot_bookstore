package com.project.bookstore.web.Books;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.BooksService;
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

    //책등록
    @GetMapping("/books/bookSave")
    public String bookSave() {
        return "Book/bookSave";
    }

    //책리스트
    @GetMapping("/books/bookList")
    public String bookList(Model model) {
        model.addAttribute("bookList", booksService.findAllBooks());
        return "Book/bookList";
    }

    //책 상세정보
    @GetMapping("/books/bookInfo/{ISBM}")
    public String bookInfo(@PathVariable("ISBM") String ISBM, Model model) {
        model.addAttribute("bookInfo", booksService.findBybookInfo(ISBM));
        return "Book/bookInfo";
    }

    //책 정보 수정
    @GetMapping("/books/bookUpdate/{ISBM}")
    public String bookUpdate(@PathVariable("ISBM") String ISBM, Model model) {
        model.addAttribute("bookInfo", booksService.findBybookInfo(ISBM));
        return "Book/bookUpdate";
    }

    //책정보
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
