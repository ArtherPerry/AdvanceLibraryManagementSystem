package com.example.advancelibrarymanagementsystem.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.advancelibrarymanagementsystem.entitites.Publisher;
import com.example.advancelibrarymanagementsystem.repo.PublisherRepository;
import com.example.advancelibrarymanagementsystem.service.PublisherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
 class PublisherServiceTest {

    @InjectMocks
    private PublisherService publisherService;

    @Mock
    private PublisherRepository publisherRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSavePublisher() {
        Publisher publisher = new Publisher();
        when(publisherRepository.save(publisher)).thenReturn(publisher);

        Publisher result = publisherService.savePublisher(publisher);
        assertEquals(publisher, result);
        verify(publisherRepository, times(1)).save(publisher);
    }

    @Test
    void testUpdatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setId(1L);
        when(publisherRepository.save(publisher)).thenReturn(publisher);

        Publisher result = publisherService.updatePublisher(1L, publisher);
        assertEquals(1L, result.getId());
        verify(publisherRepository, times(1)).save(publisher);
    }

    @Test
    void testDeletePublisher() {
        doNothing().when(publisherRepository).deleteById(1L);
        publisherService.deletePublisher(1L);
        verify(publisherRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindPublisherById() {
        Publisher publisher = new Publisher();
        publisher.setId(1L);
        when(publisherRepository.findById(1L)).thenReturn(Optional.of(publisher));

        Optional<Publisher> result = publisherService.findPublisherById(1L);
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testFindAllPublishers() {
        publisherService.findAllPublishers();
        verify(publisherRepository, times(1)).findAll();
    }

    @Test
    void testFindPublisherByName() {
        Publisher publisher = new Publisher();
        when(publisherRepository.findByName("Penguin")).thenReturn(Optional.of(publisher));

        Optional<Publisher> result = publisherService.findPublisherByName("Penguin");
        assertEquals(publisher, result.get());
    }
}