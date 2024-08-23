package com.example.advancelibrarymanagementsystem.repo;

import com.example.advancelibrarymanagementsystem.entitites.LibraryStaff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibraryStaffRepository extends JpaRepository<LibraryStaff,Long> {
    Optional<LibraryStaff> findByEmail(String email);
    List<LibraryStaff> findByRole(String role);
    Optional<LibraryStaff> findByPhoneNumber(String phoneNumber);
}
