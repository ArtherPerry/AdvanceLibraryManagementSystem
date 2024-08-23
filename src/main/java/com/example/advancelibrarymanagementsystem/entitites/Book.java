package com.example.advancelibrarymanagementsystem.entitites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
        @Index(name = "idx_book_isbn",columnList = "isbn"),
        @Index(name = "idx_book_category_id",columnList = "category_id")
})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String publisher;

    private String author;

    private Integer yearPublished;

    private Integer copiesAvailable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
