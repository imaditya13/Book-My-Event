package com.example.bookmyevemt.controllers;

import com.example.bookmyevemt.Exception.ActorNotFoundException;
import com.example.bookmyevemt.apis.ActorApi;
import com.example.bookmyevemt.dto.ActorRequestDto;
import com.example.bookmyevemt.dto.ActorResponseDto;
import com.example.bookmyevemt.models.Actor;
import com.example.bookmyevemt.services.ActorService;
import com.example.bookmyevemt.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ActorController implements ActorApi {

    ActorService actorService;
    @Autowired
    public ActorController(ActorService actorService)
    {
        this.actorService = actorService;
    }
    @Override
    public ResponseEntity<ActorResponseDto> createActor(ActorRequestDto requestDto) {

        ActorResponseDto responseDto;
        Actor actor = actorService.createActor(requestDto);
        responseDto = convertDto(actor);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<ActorResponseDto> getActorById(Long actorId) {
        ActorResponseDto responseDto;
        try {
           Actor actor = actorService.getActorById(actorId);
            responseDto = convertDto(actor);
        } catch (ActorNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<ActorResponseDto> getActorsByMovieId(Long movieId) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteActorById(Long actorId) {
         ActorResponseDto responseDto;
        try {
            actorService.deleteById(actorId);
        } catch (ActorNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Actor deleted successfully");
    }

    @Override
    public ResponseEntity<List<ActorResponseDto>> getAllActors() {
        List<Actor>actors = actorService.getAllActors();

       List<ActorResponseDto>responseDtos = actors.stream()
               .map(this::convertDto)
               .collect(Collectors.toList());
       return ResponseEntity.ok(responseDtos);
    }
    private ActorResponseDto convertDto(Actor actor) {
        ActorResponseDto responseDto = new ActorResponseDto();
        responseDto.setActor_id(actor.getId());
        responseDto.setName(actor.getName());
        return responseDto;
    }
}
