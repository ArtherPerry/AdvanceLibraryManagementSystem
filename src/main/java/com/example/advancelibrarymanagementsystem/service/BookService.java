package com.example.advancelibrarymanagementsystem.service;

import com.example.advancelibrarymanagementsystem.entitites.Book;
import com.example.advancelibrarymanagementsystem.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Long id,Book book){
        book.setId(id);
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public Optional<Book> findBookById(Long id){
        return bookRepository.findById(id);
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> findBookByIsbn(String isbn){
        return bookRepository.findByIsbn(isbn);
    }

    public List<Book> findBookByTitle(String title ){
        return bookRepository.findByTitleContaining(title);
    }

    public List<Book> findBookByAuthor(String author){
        return bookRepository.findByAuthorContaining(author);
    }
}
