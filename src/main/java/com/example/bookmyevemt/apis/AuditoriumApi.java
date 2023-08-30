package com.example.bookmyevemt.apis;

import com.example.bookmyevemt.dto.AuditoriumRequestDto;
import com.example.bookmyevemt.dto.AuditoriumResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/v1/city/theater/audi/")
public interface AuditoriumApi {
    @PostMapping("/")
    public ResponseEntity<AuditoriumResponseDto> createAudi(@RequestBody(required = true) AuditoriumRequestDto requestDto);

    @GetMapping("/{id}")
    public ResponseEntity<AuditoriumResponseDto>getAudiById(@PathVariable("id")Long auditoriumId);

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAudiById(@PathVariable("id")Long auditoriumId);

    @GetMapping("/all")
    public ResponseEntity<List<AuditoriumResponseDto>> getAllAudis();

}
