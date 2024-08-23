package com.example.advancelibrarymanagementsystem.repo;

import com.example.advancelibrarymanagementsystem.entitites.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorContaining(String author);
    Optional<Book> findByIsbn(String isbn);
}
