package com.example.bookmyevemt.repositories;

import com.example.bookmyevemt.models.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuditoriumRepository extends JpaRepository<Auditorium,Long> {
    @Override
    Optional<Auditorium> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

    @Override
    List<Auditorium> findAll();
    @Override
    Auditorium save(Auditorium auditorium);
}
