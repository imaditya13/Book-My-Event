package com.example.bookmyevemt.controllers;

import com.example.bookmyevemt.Exception.CityNotFoundException;
import com.example.bookmyevemt.apis.CityApi;
import com.example.bookmyevemt.dto.CityRequestDto;
import com.example.bookmyevemt.dto.CityResponseDto;
import com.example.bookmyevemt.models.City;
import com.example.bookmyevemt.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class CityController implements CityApi {
    CityService cityService;
    @Autowired
    public CityController(CityService cityService)
    {
        this.cityService = cityService;
    }

   public ResponseEntity<CityResponseDto> createCity(@RequestBody(required = true) CityRequestDto requestDto )
    {
        CityResponseDto responseDto = new CityResponseDto();

        City city = cityService.saveCity(requestDto);

        responseDto.setName(city.getName());
        responseDto.setId(city.getId());
      return ResponseEntity.ok(responseDto);
    }

    public ResponseEntity<List<CityResponseDto>> createCities(@RequestBody List<CityRequestDto> requestDto) {
       List<City> cities = cityService.createCities(requestDto);
       List<CityResponseDto>cityResponseDtos = cities.stream()
               .map(this::convertDto)
               .collect(Collectors.toList());
        return ResponseEntity.ok(cityResponseDtos);
    }

    public ResponseEntity<CityResponseDto> getCityById(@PathVariable("id")Long id)
    {
        CityResponseDto responseDto = new CityResponseDto();

        try {
            City city = cityService.getCityById(id);
            responseDto.setId(city.getId());
            responseDto.setName(city.getName());
        } catch (CityNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }


        return ResponseEntity.ok(responseDto);
    }

    public ResponseEntity<CityResponseDto> getCityByName(@PathVariable("name")String name)
    {
        CityResponseDto responseDto = new CityResponseDto();
        Optional<City> city = cityService.getCityByName(name);

        responseDto.setId(city.get().getId());
        responseDto.setName(city.get().getName());
        return ResponseEntity.ok(responseDto);
    }

    public ResponseEntity<String> deleteCityById(@PathVariable("id")Long id){

        boolean isDeleted  = cityService.deleteCityById(id);

        return ResponseEntity.ok("City Deleted Successfully");
    }
    public ResponseEntity<List<CityResponseDto>> getAllCities() {
        List<City> cities = cityService.getAllCities();


        List<CityResponseDto>cityResponseDtoList = cities.stream()
                .map(this::convertDto)
                .collect(Collectors.toList());


        return ResponseEntity.ok(cityResponseDtoList);
    }


    public ResponseEntity<String> deleteAllCities() {
        cityService.deleteAllCities();
        return ResponseEntity.ok("All cities deleted successfully");
    }

    private CityResponseDto convertDto(City city) {
        CityResponseDto dto = new CityResponseDto();
        dto.setId(city.getId());
        dto.setName(city.getName());
        return dto;
    }

}
