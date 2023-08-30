package com.example.bookmyevemt.apis;

import com.example.bookmyevemt.dto.TheaterRequestDto;
import com.example.bookmyevemt.dto.TheaterResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path = "/v1/city/theater")
public interface TheaterApi {
    @PostMapping("/")
    public ResponseEntity<TheaterResponseDto>createTheater(@RequestBody(required = true)TheaterRequestDto requestDto);

    @GetMapping("/{id}")
    public ResponseEntity<TheaterResponseDto>getTheaterById(@PathVariable("id")Long id);

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTheaterById(@PathVariable("id")Long theaterId);

    @GetMapping("/all")
    public ResponseEntity<List<TheaterResponseDto>> getAllTheaters();


}
