package com.example.bookmyevemt.controllers;

import com.example.bookmyevemt.Exception.ActorNotFoundException;
import com.example.bookmyevemt.Exception.MovieNotFoundException;
import com.example.bookmyevemt.apis.MovieApi;
import com.example.bookmyevemt.dto.MovieRequestDto;
import com.example.bookmyevemt.dto.MovieResponseDto;
import com.example.bookmyevemt.models.Movie;
import com.example.bookmyevemt.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController implements MovieApi {
    MovieService movieService;
    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }
    @Override
    public ResponseEntity<MovieResponseDto> createMovie(MovieRequestDto requestDto) {
        MovieResponseDto responseDto;
        try {
            Movie movie = movieService.createMovie(requestDto);
            responseDto = convertDto(movie);
        } catch (ActorNotFoundException e) {
            throw new RuntimeException(e);
        }
         return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<MovieResponseDto> getMovieById(Long movieId) {
        MovieResponseDto responseDto;
        try {
            Movie movie =  movieService.getMovieById(movieId);
            responseDto = convertDto(movie);
        } catch (MovieNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<String> deleteMovieById(Long movieId) {
        try {
            movieService.deleteMovieById(movieId);
        } catch (MovieNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("movie deleted successfully");
    }

    @Override
    public ResponseEntity<List<MovieResponseDto>> getAllMovies() {
        List<Movie>movies = movieService.getAllMovies();
        List<MovieResponseDto>responseDtos = movies.stream()
                .map(this::convertDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDtos);
    }

    private MovieResponseDto convertDto(Movie movie) {
        MovieResponseDto responseDto = new MovieResponseDto();
        responseDto.setName(movie.getName());
        responseDto.setFeatures(movie.getFeatures());
        responseDto.setActors(movie.getActorList());
        responseDto.setGenres(movie.getGenres());
        responseDto.setLanguages(movie.getLanguages());
        responseDto.setMovieId(movie.getId());
        return responseDto;
    }

}
