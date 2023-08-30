package com.example.bookmyevemt.Exception;

public class AuditoriumNotFoundException extends Exception{
    public AuditoriumNotFoundException(Long id)
    {
        super("this Auditorium id is NotFound : "+id);
    }
}
