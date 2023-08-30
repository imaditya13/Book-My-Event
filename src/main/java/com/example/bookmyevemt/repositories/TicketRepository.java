package com.example.bookmyevemt.repositories;

import com.example.bookmyevemt.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
