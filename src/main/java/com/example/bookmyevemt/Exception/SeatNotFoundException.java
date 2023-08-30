package com.example.bookmyevemt.Exception;

public class SeatNotFoundException extends Exception{
    public SeatNotFoundException(Long id)
    {
        super("this seat id is Not Found : "+id);
    }
}
