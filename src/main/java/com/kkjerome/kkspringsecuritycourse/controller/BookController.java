package com.kkjerome.kkspringsecuritycourse.controller;

import com.kkjerome.kkspringsecuritycourse.model.Book;
import com.kkjerome.kkspringsecuritycourse.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Api(value="Book Service",description = "My Book Store")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping("/save")
    @ApiOperation(value="store book api")
    public String saveBook(@RequestBody Book book){
        return service.saveBook(book);
    }

    @GetMapping("/searchBook/{bookId}")
    @ApiOperation(value="search book api")
    public Book getBook(@PathVariable int bookId){
        return service.getBook(bookId);
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public List<Book> deleteBook(@PathVariable int bookId){
        return service.removeBook(bookId);
    }
}
