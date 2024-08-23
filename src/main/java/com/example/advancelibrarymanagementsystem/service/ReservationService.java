package com.example.advancelibrarymanagementsystem.service;

import com.example.advancelibrarymanagementsystem.entitites.Reservation;
import com.example.advancelibrarymanagementsystem.repo.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation saveReservation(Reservation reservation){
        return  reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id,Reservation reservation){
        reservation.setId(id);
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }

    public Optional<Reservation> findReservationById(Long id){
        return reservationRepository.findById(id);
    }

    public List<Reservation> findAllReservations(){
        return reservationRepository.findAll();
    }

    public List<Reservation> findReservationsByMemberId(Long memberId){
        return reservationRepository.findByMember_Id(memberId);
    }

    public List<Reservation> findReservationsByBookId(Long bookId){
        return reservationRepository.findByBook_Id(bookId);
    }



}
