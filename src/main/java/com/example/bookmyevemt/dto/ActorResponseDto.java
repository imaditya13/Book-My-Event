package com.example.bookmyevemt.dto;

import com.example.bookmyevemt.models.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ActorResponseDto {
    private Long actor_id;
    private String name;
    private List<Movie>movies;
}
