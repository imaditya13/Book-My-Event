package com.example.bookmyevemt.dto;

import com.example.bookmyevemt.models.ResponseStatus;
import com.example.bookmyevemt.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenerateTicketResponseDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;
}
