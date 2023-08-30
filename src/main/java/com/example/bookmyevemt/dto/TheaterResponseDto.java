package com.example.bookmyevemt.dto;

import com.example.bookmyevemt.models.City;
import com.example.bookmyevemt.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheaterResponseDto {

    private Long theaterId;
    private String name;
    private String adress;
    private City city;
//    private ResponseStatus responseStatus;
}
