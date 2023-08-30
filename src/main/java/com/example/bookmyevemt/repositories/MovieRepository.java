package com.example.bookmyevemt.repositories;

import com.example.bookmyevemt.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Override
    Movie save(Movie movie);

    @Override
    void deleteById(Long movieId);

    @Override
    Optional<Movie> findById(Long movieId);

    @Override
    List<Movie> findAll();
}
