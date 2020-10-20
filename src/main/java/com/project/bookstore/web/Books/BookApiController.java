package com.project.bookstore.web.Books;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.BooksService;
import com.project.bookstore.web.Books.dto.BookListDto;
import com.project.bookstore.web.Books.dto.BooksSaveDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> bookSave (@RequestBody BooksSaveDto booksSaveDto) {
        ApiResponse result = null;
        BookListDto isbmCheck = new BookListDto(booksService.findById(booksSaveDto.getISBM()));
        if(isbmCheck.getISBM() == null) {
            try{
                if(booksSaveDto.getISBM() != "") {
                    result = new ApiResponse(true, "성공", booksService.booksave(booksSaveDto));
                    return ResponseEntity.ok().body(result);
                } else {
                    result = new ApiResponse(false, "실패", null);
                    return ResponseEntity.badRequest().body(result);
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = new com.project.bookstore.config.ApiResponse(false, e.getMessage(), null);
                return ResponseEntity.badRequest().body(result);
            }
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
