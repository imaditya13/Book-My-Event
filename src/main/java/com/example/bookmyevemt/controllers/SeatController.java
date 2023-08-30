package com.example.bookmyevemt.controllers;

import com.example.bookmyevemt.Exception.AuditoriumNotFoundException;
import com.example.bookmyevemt.Exception.SeatNotFoundException;
import com.example.bookmyevemt.apis.SeatApi;
import com.example.bookmyevemt.dto.SeatRequestDto;
import com.example.bookmyevemt.dto.SeatResponseDto;
import com.example.bookmyevemt.models.Seat;
import com.example.bookmyevemt.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SeatController implements SeatApi {
    SeatService seatService;
    @Autowired
    public SeatController(SeatService seatService)
    {
        this.seatService = seatService;
    }
    @Override
    public ResponseEntity<SeatResponseDto> createSeat(SeatRequestDto requestDto) {
        SeatResponseDto responseDto;

        try {
          Seat seat = seatService.createSeatById(requestDto);
            responseDto = convertDto(seat);
        } catch (AuditoriumNotFoundException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(responseDto);
    }
    @Override
    public ResponseEntity<SeatResponseDto> getSeatById(Long seatId) {
        SeatResponseDto responseDto;

        try {
           Seat seat = seatService.getSeatById(seatId);
            responseDto = convertDto(seat);
        } catch (SeatNotFoundException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(responseDto);
    }
    @Override
    public ResponseEntity<String> deleteSeatById(Long seatId) {

        try {
            seatService.deleteSeatById(seatId);
        } catch (SeatNotFoundException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok("Seat DeletedSuccessfully");
    }

    @Override
    public ResponseEntity<List<SeatResponseDto>> getAllSeats() {
        List<Seat>seats = seatService.getAllSeats();
        List<SeatResponseDto>seatResponseDtos = seats.stream()
                .map(this::convertDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(seatResponseDtos);
    }
    private SeatResponseDto convertDto(Seat seat) {
        SeatResponseDto responseDto = new SeatResponseDto();
        responseDto.setRow(seat.getRow());
        responseDto.setCol(seat.getCol());
        responseDto.setSeatId(seat.getId());
        responseDto.setAuditorium(seat.getAuditorium());
        responseDto.setSeatStatus(seat.getSeatStatus());
        responseDto.setSeatType(seat.getSeatType());
        return responseDto;
    }
}
