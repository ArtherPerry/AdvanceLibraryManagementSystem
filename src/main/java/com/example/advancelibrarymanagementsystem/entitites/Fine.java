package com.example.advancelibrarymanagementsystem.entitites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(indexes = {
        @Index(name = "idx_fine_loan_id",columnList = "loan_id"),
        @Index(name = "idx_fine_paid",columnList = "paid")
})
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id",nullable = false)
    private Loan loan;

    private Double amount;
    private LocalDate issuedDate;
    private Boolean paid;
}
