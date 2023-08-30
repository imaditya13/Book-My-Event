package com.example.bookmyevemt.Exception;

public class ShowSeatNotFoundException extends Exception{
    public ShowSeatNotFoundException(Long showSeatId)
    {
        super("Thi seat : "+showSeatId+" is not Available for Booking Please Select other seats");
    }
}
