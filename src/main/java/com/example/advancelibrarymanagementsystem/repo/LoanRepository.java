package com.example.advancelibrarymanagementsystem.repo;

import com.example.advancelibrarymanagementsystem.entitites.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan,Long> {
    List<Loan> findByMember_Id(Long memberId);
    List<Loan> findByBook_Id(Long bookId);
    List<Loan> findByDueDateBefore(LocalDate date);

}
