package com.example.bookmyevemt.Exception;

public class MovieNotFoundException extends Exception{
    public MovieNotFoundException(Long id)
    {
        super("This movie id is not found : "+id);
    }
}
