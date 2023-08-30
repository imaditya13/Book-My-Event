package com.example.bookmyevemt.apis;

import com.example.bookmyevemt.dto.CityRequestDto;
import com.example.bookmyevemt.dto.CityResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "v1/city")
public interface CityApi {

    @PostMapping(path = "/")
   public ResponseEntity<CityResponseDto> createCity(@RequestBody(required = true) CityRequestDto requestDto);
    @PostMapping("/create")
    public ResponseEntity<List<CityResponseDto>> createCities(@RequestBody List<CityRequestDto> requestDto);

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<CityResponseDto> getCityById(@PathVariable("id")Long id);
    @GetMapping(path = "/name/{name}")
    public ResponseEntity<CityResponseDto> getCityByName(@PathVariable("name")String name);
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCityById(@PathVariable("id")Long id);
    @GetMapping("/all")
    public ResponseEntity<List<CityResponseDto>> getAllCities();
    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllCities();
    }
