package com.example.bookmyevemt.dto;

import com.example.bookmyevemt.models.Feature;
import com.example.bookmyevemt.models.Theater;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuditoriumRequestDto {
    private String name;
    private List<Feature>features;
    private Long theaterId;
}
