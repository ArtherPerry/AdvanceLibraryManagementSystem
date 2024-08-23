package com.example.advancelibrarymanagementsystem.repo;

import com.example.advancelibrarymanagementsystem.entitites.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    List<Reservation> findByMember_Id(Long memberId);
    List<Reservation> findByBook_Id(Long bookId);
}
