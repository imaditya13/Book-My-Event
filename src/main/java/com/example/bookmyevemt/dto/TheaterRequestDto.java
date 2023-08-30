package com.example.bookmyevemt.dto;

import com.example.bookmyevemt.models.City;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheaterRequestDto {
    private Long TheaterId;
    private String name;
    private String address;
    private Long cityId;


}
