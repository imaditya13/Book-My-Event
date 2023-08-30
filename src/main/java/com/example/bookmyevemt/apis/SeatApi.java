package com.example.bookmyevemt.apis;

import com.example.bookmyevemt.dto.SeatRequestDto;
import com.example.bookmyevemt.dto.SeatResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(path = "/v1/city/theater/audi/seat")
public interface SeatApi {
    @PostMapping("/")
    public ResponseEntity<SeatResponseDto> createSeat(@RequestBody(required = true) SeatRequestDto requestDto);

    @GetMapping("/{id}")
    public ResponseEntity<SeatResponseDto>getSeatById(@PathVariable("id")Long seatId);

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSeatById(@PathVariable("id")Long seatId);

    @GetMapping("/all")
    public ResponseEntity<List<SeatResponseDto>> getAllSeats();
}
