package com.project.bookstore.web;

import com.project.bookstore.service.users.BooksService;
import com.project.bookstore.web.dto.Books.BooksSaveDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
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
    public String bookSave (@RequestBody BooksSaveDto booksSaveDto) {
        return booksService.booksave(booksSaveDto);
    }
}
