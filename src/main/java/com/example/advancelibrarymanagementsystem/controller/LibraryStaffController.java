package com.example.advancelibrarymanagementsystem.controller;

import com.example.advancelibrarymanagementsystem.entitites.LibraryStaff;
import com.example.advancelibrarymanagementsystem.service.LibraryStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff")
public class LibraryStaffController {

    @Autowired
    private LibraryStaffService libraryStaffService;

    @PostMapping
    public ResponseEntity<LibraryStaff> createLibraryStaff(@RequestBody LibraryStaff libraryStaff) {
        LibraryStaff savedLibraryStaff = libraryStaffService.saveLibraryStaff(libraryStaff);
        return ResponseEntity.ok(savedLibraryStaff);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryStaff> updateLibraryStaff(@PathVariable Long id, @RequestBody LibraryStaff libraryStaff) {
        LibraryStaff updatedLibraryStaff = libraryStaffService.updateLibraryStaff(id, libraryStaff);
        return ResponseEntity.ok(updatedLibraryStaff);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibraryStaff(@PathVariable Long id) {
        libraryStaffService.deleteLibraryStaff(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LibraryStaff>> getLibraryStaffById(@PathVariable Long id) {
        Optional<LibraryStaff> libraryStaff = libraryStaffService.findLibraryStaffById(id);
        return ResponseEntity.ok(libraryStaff);
    }

    @GetMapping
    public ResponseEntity<List<LibraryStaff>> getAllLibraryStaff() {
        List<LibraryStaff> libraryStaff = libraryStaffService.findAllLibraryStaff();
        return ResponseEntity.ok(libraryStaff);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<LibraryStaff>> getLibraryStaffByEmail(@PathVariable String email) {
        Optional<LibraryStaff> libraryStaff = libraryStaffService.findLibraryStaffByEmail(email);
        return ResponseEntity.ok(libraryStaff);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<Optional<LibraryStaff>> getLibraryStaffByPhoneNumber(@PathVariable String phone) {
        Optional<LibraryStaff> libraryStaff = libraryStaffService.findLibraryStaffByPhoneNumber(phone);
        return ResponseEntity.ok(libraryStaff);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<LibraryStaff>> getLibraryStaffByRole(@PathVariable String role) {
        List<LibraryStaff> libraryStaffs = libraryStaffService.findLibraryStaffByRole(role);
        return ResponseEntity.ok(libraryStaffs);
    }
}
