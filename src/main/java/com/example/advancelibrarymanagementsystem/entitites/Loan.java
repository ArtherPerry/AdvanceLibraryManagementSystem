package com.example.advancelibrarymanagementsystem.entitites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(indexes = {
        @Index(name = "idx_loan_book_id",columnList = "book_id"),
        @Index(name = "idx_loan_member_id",columnList = "member_id"),
        @Index(name = "idx_loan_dueDate",columnList = "dueDate")
})
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id",nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

}
