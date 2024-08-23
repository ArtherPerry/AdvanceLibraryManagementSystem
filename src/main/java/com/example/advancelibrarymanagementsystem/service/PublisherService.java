package com.example.advancelibrarymanagementsystem.service;

import com.example.advancelibrarymanagementsystem.entitites.Publisher;
import com.example.advancelibrarymanagementsystem.repo.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public Publisher savePublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public Publisher updatePublisher(Long id,Publisher publisher){
        publisher.setId(id);
        return publisherRepository.save(publisher);
    }

    public void deletePublisher(Long id){
        publisherRepository.deleteById(id);
    }

    public Optional<Publisher> findPublisherById(Long id){
        return publisherRepository.findById(id);
    }

    public List<Publisher> findAllPublishers(){
        return publisherRepository.findAll();
    }

    public Optional<Publisher> findPublisherByName(String name){
        return publisherRepository.findByName(name);
    }
}
