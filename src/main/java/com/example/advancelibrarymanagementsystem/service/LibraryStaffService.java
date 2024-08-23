package com.example.advancelibrarymanagementsystem.service;

import com.example.advancelibrarymanagementsystem.entitites.LibraryStaff;
import com.example.advancelibrarymanagementsystem.repo.LibraryStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryStaffService {

    @Autowired
    private LibraryStaffRepository libraryStaffRepository;

    public LibraryStaff saveLibraryStaff(LibraryStaff libraryStaff){
        return libraryStaffRepository.save(libraryStaff);
    }

    public LibraryStaff updateLibraryStaff(Long id,LibraryStaff libraryStaff){
        libraryStaff.setId(id);
        return libraryStaffRepository.save(libraryStaff);
    }

    public void deleteLibraryStaff(Long id){
        libraryStaffRepository.deleteById(id);
    }

    public Optional<LibraryStaff> findLibraryStaffById(Long id){
        return libraryStaffRepository.findById(id);
    }

    public List<LibraryStaff> findAllLibraryStaff(){
        return libraryStaffRepository.findAll();
    }

    public Optional<LibraryStaff> findLibraryStaffByEmail(String email){
        return libraryStaffRepository.findByEmail(email);
    }

    public Optional<LibraryStaff> findLibraryStaffByPhoneNumber(String phoneNumber){
        return libraryStaffRepository.findByPhoneNumber(phoneNumber);
    }
    public List<LibraryStaff> findLibraryStaffByRole(String role){
        return libraryStaffRepository.findByRole(role);
    }


}


