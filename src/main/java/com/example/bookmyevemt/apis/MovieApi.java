package com.example.bookmyevemt.apis;

import com.example.bookmyevemt.dto.MovieRequestDto;
import com.example.bookmyevemt.dto.MovieResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/v1/movie/")

public interface MovieApi {
    @PostMapping("/")
    public ResponseEntity<MovieResponseDto> createMovie(@RequestBody(required = true) MovieRequestDto requestDto);

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDto>getMovieById(@PathVariable("id")Long movieId);

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovieById(@PathVariable("id")Long movieId);

    @GetMapping("/all")
    public ResponseEntity<List<MovieResponseDto>> getAllMovies();
}
