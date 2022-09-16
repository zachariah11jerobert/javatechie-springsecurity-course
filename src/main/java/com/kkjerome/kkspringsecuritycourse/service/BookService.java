package com.kkjerome.kkspringsecuritycourse.service;

import com.kkjerome.kkspringsecuritycourse.dao.BookRepository;
import com.kkjerome.kkspringsecuritycourse.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public String saveBook(Book book){
        repository.save(book);
        return "book saved with id : "+book.getBookId();
    }

    public Book getBook(int bookId){
        return repository.findByBookId(bookId);
    }

    public List<Book> removeBook(int bookId){
        repository.deleteById(bookId);
        return repository.findAll();
    }
}
