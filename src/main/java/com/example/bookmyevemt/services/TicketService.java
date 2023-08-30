package com.example.bookmyevemt.services;


import com.example.bookmyevemt.Exception.ShowNotFoundException;
import com.example.bookmyevemt.Exception.ShowSeatNotFoundException;
import com.example.bookmyevemt.Exception.UserNotFoundException;
import com.example.bookmyevemt.models.*;
import com.example.bookmyevemt.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
 TicketRepository ticketRepository;
 ShowSeatService showSeatService;
 ShowService showService;
 UserService userService;
 PaymentService paymentService;

 @Autowired
 public TicketService(TicketRepository ticketRepository, ShowService showService,
                      ShowSeatService showSeatService,UserService userService,PaymentService paymentService)
 {
     this.ticketRepository = ticketRepository;
     this.showService = showService;
     this.showSeatService = showSeatService;
     this.userService = userService;
     this.paymentService = paymentService;
 }
    public Ticket createTicket(Long showId, Long userId, List<Long> showSeatIds) throws ShowSeatNotFoundException, UserNotFoundException, ShowNotFoundException {
         List<ShowSeat>showSeats = showSeatService.getseatsByIds(showSeatIds);

         for(ShowSeat showSeat : showSeats)
         {
             if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
             {
                 throw new ShowSeatNotFoundException(showSeat.getId());
             }
         }

        showSeats = showSeatService.getseatsByIdWithLock(showSeatIds);

        for(ShowSeat showSeat : showSeats)
        {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
            {
                throw new ShowSeatNotFoundException(showSeat.getId());
            }
        }

        for (ShowSeat showSeat : showSeats)
        {
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.saveShowSeat(showSeat);
        }

        Optional<Show> show = showService.getShowById(showId);
         if(show.isEmpty()) throw new ShowNotFoundException(showId);

        Optional<User> user = userService.getUserById(userId);
        if(user.isEmpty()) throw new UserNotFoundException(userId);
        Ticket ticket = new Ticket();

        ticket.setUser(user.get());
        ticket.setShow(show.get());
        ticket.setShowSeatList(showSeats);
        ticket.setTicketStatus(TicketStatus.PENDING);

        if(paymentService.Payment())
        {
            ticket.setTicketStatus(TicketStatus.SUCCESS);
        }
        return ticket;
    }
}
