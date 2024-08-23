package com.example.advancelibrarymanagementsystem.controller;

import com.example.advancelibrarymanagementsystem.entitites.Publisher;
import com.example.advancelibrarymanagementsystem.exceptionHandling.ResourceNotFoundException;
import com.example.advancelibrarymanagementsystem.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    private static final String PUBLISHER_NOT_FOUND = "Publisher not found with id: ";

    @PostMapping
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) {
        Publisher savedPublisher = publisherService.savePublisher(publisher);
        return ResponseEntity.ok(savedPublisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable Long id, @RequestBody Publisher publisherDetails) {
        Optional<Publisher> publisher = publisherService.findPublisherById(id);
        if (publisher.isEmpty()) {
            throw new ResourceNotFoundException(PUBLISHER_NOT_FOUND + id);
        }
        Publisher updatedPublisher = publisherService.updatePublisher(id, publisherDetails);
        return ResponseEntity.ok(updatedPublisher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        Optional<Publisher> publisher = publisherService.findPublisherById(id);
        if (publisher.isEmpty()) {
            throw new ResourceNotFoundException(PUBLISHER_NOT_FOUND + id);
        }
        publisherService.deletePublisher(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Long id) {
        Publisher publisher = publisherService.findPublisherById(id)
                .orElseThrow(() -> new ResourceNotFoundException(PUBLISHER_NOT_FOUND + id));
        return ResponseEntity.ok(publisher);
    }

    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        List<Publisher> publishers = publisherService.findAllPublishers();
        return ResponseEntity.ok(publishers);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Optional<Publisher>> getPublisherByName(@PathVariable String name) {
        Optional<Publisher> publisher = publisherService.findPublisherByName(name);
        if (publisher.isEmpty()) {
            throw new ResourceNotFoundException(PUBLISHER_NOT_FOUND + name);
        }
        return ResponseEntity.ok(publisher);
    }
}