package com.project.bookstore.web.Books;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.BooksService;
import com.project.bookstore.web.Books.dto.BookListDto;
import com.project.bookstore.web.Books.dto.BookSaveDto;
import com.project.bookstore.web.Books.dto.BookUpdateDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "도서", description = "도서 관리", tags = { "도서" })
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class BookApiController {

    private final BooksService booksService;

    @ApiOperation(value = "도서등록")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "제목", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "content", value = "도서", required = true, dataType = "string", paramType = "query", defaultValue = ""), })
    @PostMapping("/api/books/save")
    public ResponseEntity<?> bookSave (@RequestBody BookSaveDto booksSaveDto) {
        ApiResponse result = null;
        BookListDto isbnCheck = new BookListDto(booksService.findById(booksSaveDto.getIsbn()));
        if(isbnCheck.getIsbn() == null) {
            try{
                if(booksSaveDto.getIsbn() != "") {
                    result = new ApiResponse(true, "성공", booksService.booksave(booksSaveDto));
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
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "도서수정")
    @PostMapping("/api/books/update/{isbn}")
    public ResponseEntity<?> bookUpdate (@PathVariable("isbn") String isbn, @RequestBody BookUpdateDto bookUpdateDto) {
        ApiResponse result = null;
        try{
            System.out.println(isbn);
            result = new ApiResponse(true, "성공", booksService.bookUpdate(isbn, bookUpdateDto));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "도서검색")
    @PostMapping("/booksearch/{bookName}")
    public ResponseEntity<?> booksearch (@PathVariable("bookName") String bookName, @RequestBody BookListDto bookListDto) {
        ApiResponse result = null;
        BookListDto booknameCheck = new BookListDto(booksService.findById(bookListDto.getBookName()));
        if(booknameCheck.getBookName() == null) {
            try{
                if(bookListDto.getBookName() != ""){
                    result = new ApiResponse(true, "성공", booksService.bookName(bookName, bookListDto));
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
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @DeleteMapping("/api/books/delete/{isbn}")
    public String delete(@PathVariable("isbn") String isbn) {
        booksService.delete(isbn);
        return isbn;
    }
}
