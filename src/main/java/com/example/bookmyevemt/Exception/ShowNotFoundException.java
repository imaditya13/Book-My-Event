package com.example.bookmyevemt.Exception;

public class ShowNotFoundException extends Exception{
    public ShowNotFoundException(Long showId)
    {
        super("This Show :"+showId+"is not found in database");
    }
}
