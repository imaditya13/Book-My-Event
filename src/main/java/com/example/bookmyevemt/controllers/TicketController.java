package com.example.bookmyevemt.controllers;

import com.example.bookmyevemt.Exception.ShowNotFoundException;
import com.example.bookmyevemt.Exception.ShowSeatNotFoundException;
import com.example.bookmyevemt.Exception.UserNotFoundException;
import com.example.bookmyevemt.dto.GenerateTicketRequestDto;
import com.example.bookmyevemt.dto.GenerateTicketResponseDto;
import com.example.bookmyevemt.models.ResponseStatus;
import com.example.bookmyevemt.models.Ticket;
import com.example.bookmyevemt.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService)
    {
        this.ticketService = ticketService;
    }
        public GenerateTicketResponseDto bookMovieTicket(GenerateTicketRequestDto requestDto)
        {
            GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();

            try {
                Ticket ticket  = ticketService.createTicket(requestDto.getShowId(),requestDto.getUserId(),
                                                         requestDto.getShowSeatIds());
                responseDto.setTicket(ticket);
                responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            } catch (ShowSeatNotFoundException e) {
               System.out.println(e.getMessage());
               responseDto.setResponseStatus(ResponseStatus.FAILURE);
            } catch (UserNotFoundException e) {
                System.out.println(e.getMessage());
                responseDto.setResponseStatus(ResponseStatus.FAILURE);
            } catch (ShowNotFoundException e) {
                System.out.println(e.getMessage());
                responseDto.setResponseStatus(ResponseStatus.FAILURE);
            }

            return responseDto;
        }
}
