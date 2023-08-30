package com.example.bookmyevemt.dto;

import com.example.bookmyevemt.models.Feature;
import com.example.bookmyevemt.models.Theater;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuditoriumResponseDto {
    private Long auditoriumId;
    private String name;
    private List<Feature>features;
    private String TheaterName;
}
