package com.example.bookmyevemt.repositories;

import com.example.bookmyevemt.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat,Long> {
    @Override
    Optional<Seat> findById(Long aLong);

    @Override
    List<Seat> findAll();

    @Override
    void deleteById(Long id);
    @Override
    Seat save(Seat seat);
}
