package com.example.bookmyevemt.apis;

import com.example.bookmyevemt.dto.ActorRequestDto;
import com.example.bookmyevemt.dto.ActorResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/v1/actor/")
public interface ActorApi {
    @PostMapping("/")
    public ResponseEntity<ActorResponseDto> createActor(@RequestBody(required = true) ActorRequestDto requestDto);

    @GetMapping("/{id}")
    public ResponseEntity<ActorResponseDto>getActorById(@PathVariable("id")Long actorId);

    @GetMapping("/movieId/{id}")
    public ResponseEntity<ActorResponseDto>getActorsByMovieId(@PathVariable("id")Long movieId);
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteActorById(@PathVariable("id")Long actorId);

    @GetMapping("/all")
    public ResponseEntity<List<ActorResponseDto>> getAllActors();

}
