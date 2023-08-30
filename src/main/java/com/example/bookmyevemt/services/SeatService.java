package com.example.bookmyevemt.services;

import com.example.bookmyevemt.Exception.AuditoriumNotFoundException;
import com.example.bookmyevemt.Exception.SeatNotFoundException;
import com.example.bookmyevemt.dto.SeatRequestDto;
import com.example.bookmyevemt.dto.SeatResponseDto;
import com.example.bookmyevemt.models.Auditorium;
import com.example.bookmyevemt.models.Seat;
import com.example.bookmyevemt.models.SeatStatus;
import com.example.bookmyevemt.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {
    SeatRepository seatRepository;
    AuditoriumService auditoriumService;
    @Autowired
    public SeatService(SeatRepository seatRepository, AuditoriumService auditoriumService)
    {
        this.seatRepository = seatRepository;
        this.auditoriumService = auditoriumService;
    }
    public Seat createSeatById(SeatRequestDto requestDto) throws AuditoriumNotFoundException {
        Long audiId = requestDto.getAudiId();
        Auditorium auditorium = auditoriumService.getAudiById(audiId);
       // System.out.println(auditorium.getTheater().getName());
        if(auditorium==null)throw new AuditoriumNotFoundException(audiId);

        Seat seat = convertToSeat(requestDto,auditorium);
        return seatRepository.save(seat);
    }

    public Seat getSeatById(Long seatId) throws SeatNotFoundException {
        Optional<Seat> seat = seatRepository.findById(seatId);
        if(seat.isEmpty())throw new SeatNotFoundException(seatId);

        return seat.get();
    }

    public void deleteSeatById(Long seatId) throws SeatNotFoundException {
        if(seatRepository.existsById(seatId))
        {
            seatRepository.deleteById(seatId);
        }
        else throw new SeatNotFoundException(seatId);
    }
    public List<Seat>getAllSeats()
    {
        return seatRepository.findAll();
    }
    private Seat convertToSeat(SeatRequestDto requestDto, Auditorium auditorium) {
       Seat seat = new Seat();
        seat.setRow(requestDto.getRow());
        seat.setCol(requestDto.getCol());
        seat.setSeatType(requestDto.getSeatType());
        seat.setAuditorium(auditorium);
        seat.setSeatStatus(SeatStatus.AVAILABLE);
        return seat;
    }
}
