package com.example.advancelibrarymanagementsystem.serviceTest;

import com.example.advancelibrarymanagementsystem.entitites.LibraryStaff;
import com.example.advancelibrarymanagementsystem.repo.LibraryStaffRepository;
import com.example.advancelibrarymanagementsystem.service.LibraryStaffService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class LibraryStaffServiceTest {

    @Mock
    private LibraryStaffRepository libraryStaffRepository;

    @InjectMocks
    private LibraryStaffService libraryStaffService;

    private LibraryStaff libraryStaff;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        libraryStaff = new LibraryStaff();
        libraryStaff.setId(1L);
        libraryStaff.setEmail("test@example.com");
        libraryStaff.setPhoneNumber("1234567890");
        libraryStaff.setRole("Admin");
    }

    @Test
    void saveLibraryStaff() {
        when(libraryStaffRepository.save(libraryStaff)).thenReturn(libraryStaff);

        LibraryStaff savedLibraryStaff = libraryStaffService.saveLibraryStaff(libraryStaff);

        assertNotNull(savedLibraryStaff);
        assertEquals(libraryStaff.getEmail(), savedLibraryStaff.getEmail());
        verify(libraryStaffRepository, times(1)).save(libraryStaff);
    }

    @Test
    void updateLibraryStaff() {
        when(libraryStaffRepository.save(libraryStaff)).thenReturn(libraryStaff);

        LibraryStaff updatedLibraryStaff = libraryStaffService.updateLibraryStaff(1L, libraryStaff);

        assertNotNull(updatedLibraryStaff);
        assertEquals(1L, updatedLibraryStaff.getId());
        verify(libraryStaffRepository, times(1)).save(libraryStaff);
    }

    @Test
    void deleteLibraryStaff() {
        doNothing().when(libraryStaffRepository).deleteById(1L);

        libraryStaffService.deleteLibraryStaff(1L);

        verify(libraryStaffRepository, times(1)).deleteById(1L);
    }

    @Test
    void findLibraryStaffById() {
        when(libraryStaffRepository.findById(1L)).thenReturn(Optional.of(libraryStaff));

        Optional<LibraryStaff> foundLibraryStaff = libraryStaffService.findLibraryStaffById(1L);

        assertTrue(foundLibraryStaff.isPresent());
        assertEquals(libraryStaff.getId(), foundLibraryStaff.get().getId());
        verify(libraryStaffRepository, times(1)).findById(1L);
    }

    @Test
    void findAllLibraryStaff() {
        List<LibraryStaff> libraryStaffList = Arrays.asList(libraryStaff);
        when(libraryStaffRepository.findAll()).thenReturn(libraryStaffList);

        List<LibraryStaff> allLibraryStaff = libraryStaffService.findAllLibraryStaff();

        assertEquals(1, allLibraryStaff.size());
        verify(libraryStaffRepository, times(1)).findAll();
    }

    @Test
    void findLibraryStaffByEmail() {
        when(libraryStaffRepository.findByEmail("test@example.com")).thenReturn(Optional.of(libraryStaff));

        Optional<LibraryStaff> foundLibraryStaff = libraryStaffService.findLibraryStaffByEmail("test@example.com");

        assertTrue(foundLibraryStaff.isPresent());
        assertEquals(libraryStaff.getEmail(), foundLibraryStaff.get().getEmail());
        verify(libraryStaffRepository, times(1)).findByEmail("test@example.com");
    }

    @Test
    void findLibraryStaffByPhoneNumber() {
        when(libraryStaffRepository.findByPhoneNumber("1234567890")).thenReturn(Optional.of(libraryStaff));

        Optional<LibraryStaff> foundLibraryStaff = libraryStaffService.findLibraryStaffByPhoneNumber("1234567890");

        assertTrue(foundLibraryStaff.isPresent());
        assertEquals(libraryStaff.getPhoneNumber(), foundLibraryStaff.get().getPhoneNumber());
        verify(libraryStaffRepository, times(1)).findByPhoneNumber("1234567890");
    }


    @Test
    void findLibraryStaffByRole() {
        List<LibraryStaff> libraryStaffList = Arrays.asList(libraryStaff);
        when(libraryStaffRepository.findByRole("Admin")).thenReturn(libraryStaffList);

        List<LibraryStaff> foundLibraryStaffByRole = libraryStaffService.findLibraryStaffByRole("Admin");

        assertEquals(1, foundLibraryStaffByRole.size());
        assertEquals(libraryStaff.getRole(), foundLibraryStaffByRole.get(0).getRole());
        verify(libraryStaffRepository, times(1)).findByRole("Admin");
    }
}