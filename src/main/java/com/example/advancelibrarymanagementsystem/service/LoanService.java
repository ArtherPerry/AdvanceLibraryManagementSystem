package com.example.advancelibrarymanagementsystem.service;

import com.example.advancelibrarymanagementsystem.entitites.Loan;
import com.example.advancelibrarymanagementsystem.repo.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Loan saveLoan(Loan loan){
        return loanRepository.save(loan);
    }

    public Loan updateLoan(Long id,Loan loan){
        loan.setId(id);
        return loanRepository.save(loan);
    }

    public void deleteLoan(Long id){
        loanRepository.deleteById(id);
    }

    public Optional<Loan> findLoanById(Long id){
        return loanRepository.findById(id);
    }

    public List<Loan> findAllLoans(){
        return loanRepository.findAll();
    }

    public List<Loan> findLoansByMemberId(Long memberId){
        return loanRepository.findByMember_Id(memberId);
    }

    public List<Loan> findLoansByBookId(Long bookId){
        return loanRepository.findByBook_Id(bookId);
    }

    public List<Loan> findLoansByDueDateBefore(LocalDate date){
        return loanRepository.findByDueDateBefore(date);
    }
}
