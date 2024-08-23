package com.example.advancelibrarymanagementsystem.controller;

import com.example.advancelibrarymanagementsystem.entitites.Reservation;
import com.example.advancelibrarymanagementsystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation savedReservation = reservationService.saveReservation(reservation);
        return ResponseEntity.ok(savedReservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        Reservation updatedReservation = reservationService.updateReservation(id, reservation);
        return ResponseEntity.ok(updatedReservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reservation>> getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.findReservationById(id);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.findAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<Reservation>> getReservationsByMemberId(@PathVariable Long memberId) {
        List<Reservation> reservations = reservationService.findReservationsByMemberId(memberId);
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Reservation>> getReservationsByBookId(@PathVariable Long bookId) {
        List<Reservation> reservations = reservationService.findReservationsByBookId(bookId);
        return ResponseEntity.ok(reservations);
    }
}