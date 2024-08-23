package com.example.advancelibrarymanagementsystem.serviceTest;
import com.example.advancelibrarymanagementsystem.entitites.Loan;
import com.example.advancelibrarymanagementsystem.repo.LoanRepository;
import com.example.advancelibrarymanagementsystem.service.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoanServiceTest {

    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanService loanService;

    private Loan loan;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        loan = new Loan();
        loan.setId(1L);
        loan.setDueDate(LocalDate.of(2024, 9, 1));
        // Initialize other fields of `Loan` if necessary
    }

    @Test
    void saveLoan() {
        when(loanRepository.save(loan)).thenReturn(loan);

        Loan savedLoan = loanService.saveLoan(loan);

        assertNotNull(savedLoan);
        assertEquals(loan.getId(), savedLoan.getId());
        verify(loanRepository, times(1)).save(loan);
    }

    @Test
    void updateLoan() {
        Loan updatedLoan = new Loan();
        updatedLoan.setId(1L);
        updatedLoan.setDueDate(LocalDate.of(2024, 10, 1));
        // Set other fields for updatedLoan as necessary

        when(loanRepository.save(updatedLoan)).thenReturn(updatedLoan);

        Loan result = loanService.updateLoan(1L, updatedLoan);

        assertNotNull(result);
        assertEquals(updatedLoan.getId(), result.getId());
        verify(loanRepository, times(1)).save(updatedLoan);
    }

    @Test
    void deleteLoan() {
        Long loanId = 1L;

        doNothing().when(loanRepository).deleteById(loanId);

        loanService.deleteLoan(loanId);

        verify(loanRepository, times(1)).deleteById(loanId);
    }

    @Test
    void findLoanById() {
        Long loanId = 1L;

        when(loanRepository.findById(loanId)).thenReturn(Optional.of(loan));

        Optional<Loan> foundLoan = loanService.findLoanById(loanId);

        assertTrue(foundLoan.isPresent());
        assertEquals(loan.getId(), foundLoan.get().getId());
        verify(loanRepository, times(1)).findById(loanId);
    }

    @Test
    void findAllLoans() {
        when(loanRepository.findAll()).thenReturn(Arrays.asList(loan));

        List<Loan> loans = loanService.findAllLoans();

        assertNotNull(loans);
        assertFalse(loans.isEmpty());
        assertEquals(1, loans.size());
        verify(loanRepository, times(1)).findAll();
    }

    @Test
    void findLoansByMemberId() {
        Long memberId = 1L;

        when(loanRepository.findByMember_Id(memberId)).thenReturn(Arrays.asList(loan));

        List<Loan> loans = loanService.findLoansByMemberId(memberId);

        assertNotNull(loans);
        assertFalse(loans.isEmpty());
        assertEquals(1, loans.size());
        verify(loanRepository, times(1)).findByMember_Id(memberId);
    }

    @Test
    void findLoansByBookId() {
        Long bookId = 1L;

        when(loanRepository.findByBook_Id(bookId)).thenReturn(Arrays.asList(loan));

        List<Loan> loans = loanService.findLoansByBookId(bookId);

        assertNotNull(loans);
        assertFalse(loans.isEmpty());
        assertEquals(1, loans.size());
        verify(loanRepository, times(1)).findByBook_Id(bookId);
    }

    @Test
    void findLoansByDueDateBefore() {
        LocalDate dueDate = LocalDate.of(2024, 9, 1);

        when(loanRepository.findByDueDateBefore(dueDate)).thenReturn(Arrays.asList(loan));

        List<Loan> loans = loanService.findLoansByDueDateBefore(dueDate);

        assertNotNull(loans);
        assertFalse(loans.isEmpty());
        assertEquals(1, loans.size());
        verify(loanRepository, times(1)).findByDueDateBefore(dueDate);
    }
}