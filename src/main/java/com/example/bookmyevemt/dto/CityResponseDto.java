package com.example.bookmyevemt.dto;

import com.example.bookmyevemt.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CityResponseDto {
    private String name;
    private Long id;
//    private ResponseStatus responseStatus;
}
