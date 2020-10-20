package com.project.bookstore.web.Books;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.schema.Model;

@RequiredArgsConstructor
@Controller
public class BookController {
    private final BooksService booksService;
    //도서등록
    @GetMapping("/books/bookSave")
    public String bookSave() {
        return "Book/bookSave";
    }
    //도서정보
    @GetMapping("/books/bookInfo")
    public ResponseEntity<?> bookInfo(Model model) {
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
