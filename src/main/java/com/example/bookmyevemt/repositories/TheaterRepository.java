package com.example.bookmyevemt.repositories;

import com.example.bookmyevemt.models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TheaterRepository extends JpaRepository<Theater,Long> {

    @Override
    Optional<Theater> findById(Long aLong);

    @Override
    List<Theater> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    Theater save(Theater theater);
}
