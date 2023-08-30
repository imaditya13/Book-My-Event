package com.example.bookmyevemt.dto;

import com.example.bookmyevemt.models.Auditorium;
import com.example.bookmyevemt.models.SeatStatus;
import com.example.bookmyevemt.models.SeatType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SeatResponseDto {
    private Long seatId;
    private Integer row;
    private Integer col;
    private Auditorium auditorium;
    private SeatStatus seatStatus;
    private SeatType seatType;
}
