package com.example.advancelibrarymanagementsystem.serviceTest;
import com.example.advancelibrarymanagementsystem.entitites.Reservation;
import com.example.advancelibrarymanagementsystem.repo.ReservationRepository;
import com.example.advancelibrarymanagementsystem.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    private Reservation reservation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reservation = new Reservation();
        reservation.setId(1L);
        // Initialize other fields of `Reservation` if necessary
    }

    @Test
    void saveReservation() {
        when(reservationRepository.save(reservation)).thenReturn(reservation);

        Reservation savedReservation = reservationService.saveReservation(reservation);

        assertNotNull(savedReservation);
        assertEquals(reservation.getId(), savedReservation.getId());
        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    void updateReservation() {
        Reservation updatedReservation = new Reservation();
        updatedReservation.setId(1L);
        // Set other fields for updatedReservation as necessary

        when(reservationRepository.save(updatedReservation)).thenReturn(updatedReservation);

        Reservation result = reservationService.updateReservation(1L, updatedReservation);

        assertNotNull(result);
        assertEquals(updatedReservation.getId(), result.getId());
        verify(reservationRepository, times(1)).save(updatedReservation);
    }

    @Test
    void deleteReservation() {
        Long reservationId = 1L;

        doNothing().when(reservationRepository).deleteById(reservationId);

        reservationService.deleteReservation(reservationId);

        verify(reservationRepository, times(1)).deleteById(reservationId);
    }

    @Test
    void findReservationById() {
        Long reservationId = 1L;

        when(reservationRepository.findById(reservationId)).thenReturn(Optional.of(reservation));

        Optional<Reservation> foundReservation = reservationService.findReservationById(reservationId);

        assertTrue(foundReservation.isPresent());
        assertEquals(reservation.getId(), foundReservation.get().getId());
        verify(reservationRepository, times(1)).findById(reservationId);
    }

    @Test
    void findAllReservations() {
        when(reservationRepository.findAll()).thenReturn(Arrays.asList(reservation));

        List<Reservation> reservations = reservationService.findAllReservations();

        assertNotNull(reservations);
        assertFalse(reservations.isEmpty());
        assertEquals(1, reservations.size());
        verify(reservationRepository, times(1)).findAll();
    }

    @Test
    void findReservationsByMemberId() {
        Long memberId = 1L;

        when(reservationRepository.findByMember_Id(memberId)).thenReturn(Arrays.asList(reservation));

        List<Reservation> reservations = reservationService.findReservationsByMemberId(memberId);

        assertNotNull(reservations);
        assertFalse(reservations.isEmpty());
        assertEquals(1, reservations.size());
        verify(reservationRepository, times(1)).findByMember_Id(memberId);
    }

    @Test
    void findReservationsByBookId() {
        Long bookId = 1L;

        when(reservationRepository.findByBook_Id(bookId)).thenReturn(Arrays.asList(reservation));

        List<Reservation> reservations = reservationService.findReservationsByBookId(bookId);

        assertNotNull(reservations);
        assertFalse(reservations.isEmpty());
        assertEquals(1, reservations.size());
        verify(reservationRepository, times(1)).findByBook_Id(bookId);
    }
}