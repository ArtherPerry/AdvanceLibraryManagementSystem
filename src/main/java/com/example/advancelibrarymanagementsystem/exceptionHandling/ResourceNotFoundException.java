package com.example.advancelibrarymanagementsystem.exceptionHandling;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }

}
