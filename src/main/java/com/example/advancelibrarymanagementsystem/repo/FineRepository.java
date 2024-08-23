package com.example.advancelibrarymanagementsystem.repo;

import com.example.advancelibrarymanagementsystem.entitites.Fine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FineRepository extends JpaRepository<Fine,Long> {

    List<Fine> findByLoan_Id(Long loanId);
    List<Fine> findByPaid(Boolean paid);
}
