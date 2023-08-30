package com.example.bookmyevemt.Exception;

import com.example.bookmyevemt.dto.TheaterRequestDto;

public class TheaterIdNotFoundException extends Exception{
    public TheaterIdNotFoundException(Long id)
    {
        super("this Theater is is not found : "+id);
    }
}
