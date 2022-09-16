package com.kkjerome.kkspringsecuritycourse.dao;

import com.kkjerome.kkspringsecuritycourse.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findByBookId(int bookId);
}
