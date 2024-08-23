package com.example.advancelibrarymanagementsystem.controller;

import com.example.advancelibrarymanagementsystem.entitites.Fine;
import com.example.advancelibrarymanagementsystem.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fines")
public class FineController {

    @Autowired
    private FineService fineService;

    @PostMapping
    public ResponseEntity<Fine> createFine(@RequestBody Fine fine) {
        Fine savedFine = fineService.saveFine(fine);
        return ResponseEntity.ok(savedFine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fine> updateFine(@PathVariable Long id, @RequestBody Fine fineDetails) {
        Fine updatedFine = fineService.updateFine(id, fineDetails);
        return ResponseEntity.ok(updatedFine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFine(@PathVariable Long id) {
        fineService.deleteFine(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Fine>> getFineById(@PathVariable Long id) {
        Optional<Fine> fine = fineService.findFineById(id);
        return ResponseEntity.ok(fine);
    }

    @GetMapping
    public ResponseEntity<List<Fine>> getAllFines() {
        List<Fine> fines = fineService.findAllFines();
        return ResponseEntity.ok(fines);
    }

    @GetMapping("/loan/{loanId}")
    public ResponseEntity<List<Fine>> getFinesByLoanId(@PathVariable Long loanId) {
        List<Fine> fines = fineService.findFinesByLoanId(loanId);
        return ResponseEntity.ok(fines);
    }

    @GetMapping("/paid/{paid}")
    public ResponseEntity<List<Fine>> getFinesByPaidStatus(@PathVariable Boolean paid) {
        List<Fine> fines = fineService.findFinesByPaid(paid);
        return ResponseEntity.ok(fines);
    }
}