package com.example.bookmyevemt.controllers;

import com.example.bookmyevemt.Exception.CityNotFoundException;
import com.example.bookmyevemt.Exception.TheaterIdNotFoundException;
import com.example.bookmyevemt.apis.TheaterApi;
import com.example.bookmyevemt.dto.TheaterRequestDto;
import com.example.bookmyevemt.dto.TheaterResponseDto;
import com.example.bookmyevemt.models.Theater;
import com.example.bookmyevemt.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TheaterController implements TheaterApi {
    TheaterService theaterService;
    @Autowired
    public TheaterController(TheaterService theaterService)
    {
        this.theaterService = theaterService;
    }

    @Override
    public ResponseEntity<TheaterResponseDto> createTheater(TheaterRequestDto requestDto) {
        TheaterResponseDto responseDto = new TheaterResponseDto();
        try {
            Theater theater = theaterService.createTheater(requestDto);
            responseDto= convertDto(theater);
        } catch (CityNotFoundException e) {
            throw new RuntimeException(e);
        }

       return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<TheaterResponseDto> getTheaterById(@PathVariable("id") Long theaterId) {
        TheaterResponseDto responseDto;
        try {
            Theater theater = theaterService.getTheaterById(theaterId);
            responseDto = convertDto(theater);
        } catch (TheaterIdNotFoundException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<String> deleteTheaterById(Long theaterId) {
        try {
            theaterService.deleteById(theaterId);
        } catch (TheaterIdNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Theater Deleted Successfully");
    }

    @Override
    public ResponseEntity<List<TheaterResponseDto>> getAllTheaters() {
        TheaterResponseDto responseDto = new TheaterResponseDto();
      List<Theater>theaters = theaterService.getAllTheaters();
      List<TheaterResponseDto>responseDtos = theaters.stream()
              .map(this::convertDto)
              .collect(Collectors.toList());

        return ResponseEntity.ok(responseDtos);
    }

    private TheaterResponseDto convertDto(Theater theater) {
        TheaterResponseDto responseDto = new TheaterResponseDto();
        responseDto.setName(theater.getName());
        responseDto.setCity(theater.getCity());
        responseDto.setAdress(theater.getAdress());
        responseDto.setTheaterId(theater.getId());
        return responseDto;
    }
}
