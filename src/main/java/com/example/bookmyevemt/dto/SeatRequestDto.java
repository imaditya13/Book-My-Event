package com.example.bookmyevemt.dto;

import com.example.bookmyevemt.models.Auditorium;
import com.example.bookmyevemt.models.SeatStatus;
import com.example.bookmyevemt.models.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatRequestDto {
    private Integer row;
    private Integer col;
    private Long audiId;
    private SeatType seatType;
}
