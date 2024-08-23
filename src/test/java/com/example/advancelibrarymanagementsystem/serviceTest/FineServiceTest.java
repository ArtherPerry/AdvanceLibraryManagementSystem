package com.example.advancelibrarymanagementsystem.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.advancelibrarymanagementsystem.entitites.Fine;
import com.example.advancelibrarymanagementsystem.repo.FineRepository;
import com.example.advancelibrarymanagementsystem.service.FineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.List;
@SpringBootTest
class FineServiceTest {

    @InjectMocks
    private FineService fineService;

    @Mock
    private FineRepository fineRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveFine() {
        Fine fine = new Fine();
        when(fineRepository.save(fine)).thenReturn(fine);

        Fine result = fineService.saveFine(fine);
        assertEquals(fine, result);
        verify(fineRepository, times(1)).save(fine);
    }

    @Test
    void testUpdateFine() {
        Fine fine = new Fine();
        fine.setId(1L);
        when(fineRepository.save(fine)).thenReturn(fine);

        Fine result = fineService.updateFine(1L, fine);
        assertEquals(1L, result.getId());
        verify(fineRepository, times(1)).save(fine);
    }

    @Test
    void testDeleteFine() {
        doNothing().when(fineRepository).deleteById(1L);
        fineService.deleteFine(1L);
        verify(fineRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindFineById() {
        Fine fine = new Fine();
        fine.setId(1L);
        when(fineRepository.findById(1L)).thenReturn(Optional.of(fine));

        Optional<Fine> result = fineService.findFineById(1L);
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testFindAllFines() {
        fineService.findAllFines();
        verify(fineRepository, times(1)).findAll();
    }

    @Test
    void testFindFinesByLoanId() {
        List<Fine> fines = List.of(new Fine());
        when(fineRepository.findByLoan_Id(1L)).thenReturn(fines);

        List<Fine> result = fineService.findFinesByLoanId(1L);
        assertEquals(fines, result);
    }

    @Test
    void testFindFinesByPaid() {
        List<Fine> fines = List.of(new Fine());
        when(fineRepository.findByPaid(true)).thenReturn(fines);

        List<Fine> result = fineService.findFinesByPaid(true);
        assertEquals(fines, result);
    }
}
