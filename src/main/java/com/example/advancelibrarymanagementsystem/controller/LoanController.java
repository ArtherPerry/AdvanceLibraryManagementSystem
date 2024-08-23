package com.example.advancelibrarymanagementsystem.controller;
import com.example.advancelibrarymanagementsystem.entitites.Loan;
import com.example.advancelibrarymanagementsystem.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        Loan savedLoan = loanService.saveLoan(loan);
        return ResponseEntity.ok(savedLoan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody Loan loan) {
        Loan updatedLoan = loanService.updateLoan(id, loan);
        return ResponseEntity.ok(updatedLoan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Loan>> getLoanById(@PathVariable Long id) {
        Optional<Loan> loan = loanService.findLoanById(id);
        return ResponseEntity.ok(loan);
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanService.findAllLoans();
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<Loan>> getLoansByMemberId(@PathVariable Long memberId) {
        List<Loan> loans = loanService.findLoansByMemberId(memberId);
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Loan>> getLoansByBookId(@PathVariable Long bookId) {
        List<Loan> loans = loanService.findLoansByBookId(bookId);
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/dueDateBefore/{date}")
    public ResponseEntity<List<Loan>> getLoansByDueDateBefore(@PathVariable String date) {
        List<Loan> loans = loanService.findLoansByDueDateBefore(LocalDate.parse(date));
        return ResponseEntity.ok(loans);
    }
}