package com.example.bookmyevemt.Exception;

public class CityNotFoundException extends Exception {
    public CityNotFoundException(Long cityId)
    {
        super("City Not Found with this id = "+cityId);
    }
}
