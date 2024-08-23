package com.example.advancelibrarymanagementsystem.service;

import com.example.advancelibrarymanagementsystem.entitites.Fine;
import com.example.advancelibrarymanagementsystem.repo.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FineService {

    @Autowired
    private FineRepository fineRepository;

    public Fine saveFine(Fine fine){
        return fineRepository.save(fine);
    }

    public Fine updateFine(Long id,Fine fine){
        fine.setId(id);
        return fineRepository.save(fine);
    }

    public void  deleteFine(Long id){
        fineRepository.deleteById(id);
    }

    public Optional<Fine> findFineById(Long id){
        return fineRepository.findById(id);
    }

    public List<Fine> findAllFines(){
        return fineRepository.findAll();
    }

    public List<Fine> findFinesByLoanId(Long loanId){
        return fineRepository.findByLoan_Id(loanId);
    }

    public List<Fine> findFinesByPaid(Boolean paid){
        return fineRepository.findByPaid(paid);
    }
}
