package com.example.bookmyevemt.controllers;

import com.example.bookmyevemt.Exception.AuditoriumNotFoundException;
import com.example.bookmyevemt.Exception.TheaterIdNotFoundException;
import com.example.bookmyevemt.apis.AuditoriumApi;
import com.example.bookmyevemt.dto.AuditoriumRequestDto;
import com.example.bookmyevemt.dto.AuditoriumResponseDto;
import com.example.bookmyevemt.models.Auditorium;
import com.example.bookmyevemt.services.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuditoriumController implements AuditoriumApi {
    AuditoriumService auditoriumService;
    @Autowired
    public AuditoriumController(AuditoriumService auditoriumService)
    {
        this.auditoriumService = auditoriumService;
    }
    @Override
    public ResponseEntity<AuditoriumResponseDto> createAudi(AuditoriumRequestDto requestDto) {

        AuditoriumResponseDto responseDto ;
        try {
          Auditorium auditorium =  auditoriumService.createAudiById(requestDto);
          responseDto = convertDto(auditorium);
        } catch (TheaterIdNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<AuditoriumResponseDto> getAudiById(Long auditoriumId) {
        AuditoriumResponseDto responseDto;
        try {
            Auditorium auditorium = auditoriumService.getAudiById(auditoriumId);
            responseDto = convertDto(auditorium);
        } catch (AuditoriumNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<String> deleteAudiById(Long auditoriumId) {
        try {
            auditoriumService.deleteAudiById(auditoriumId);
        } catch (AuditoriumNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Auditorium is Deleted Successfully");
    }

    @Override
    public ResponseEntity<List<AuditoriumResponseDto>> getAllAudis() {

        List<Auditorium> auditoriums = auditoriumService.getAllAudis();
        List<AuditoriumResponseDto>responseDtos = auditoriums.stream()
                .map(this::convertDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDtos);
    }

    private AuditoriumResponseDto convertDto(Auditorium auditorium) {
        AuditoriumResponseDto responseDto = new AuditoriumResponseDto();
        responseDto.setName(auditorium.getName());
        responseDto.setAuditoriumId(auditorium.getId());
        responseDto.setFeatures(auditorium.getFeatureList());
        responseDto.setTheaterName(auditorium.getTheater().getName());
        return responseDto;
    }
}
