package com.example.bookmyevemt.repositories;

import com.example.bookmyevemt.models.Actor;
import com.example.bookmyevemt.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor,Long> {
    @Override
    Actor save(Actor actor);

    @Override
    Optional<Actor> findById(Long actorId);

    @Override
    List<Actor> findAll();

    @Override
    void deleteById(Long actorId);


}
