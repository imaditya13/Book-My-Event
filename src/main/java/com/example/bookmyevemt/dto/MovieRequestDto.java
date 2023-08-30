package com.example.bookmyevemt.dto;

import com.example.bookmyevemt.models.Actor;
import com.example.bookmyevemt.models.Feature;
import com.example.bookmyevemt.models.Genre;
import com.example.bookmyevemt.models.Language;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieRequestDto {
    private String name;
    private List<Feature>features;
    private List<Language>languages;
    private List<Genre>genres;
    private List<Long>actorIds;
}
