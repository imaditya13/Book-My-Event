package com.example.bookmyevemt.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Access(AccessType.PROPERTY)

public class Ticket extends BaseModel{
 /*   @ManyToOne
    private Show show;

    @ManyToOne
    private User user;
*/
    private Double totalAmount;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;

    private Date timeOfBooking;

  /*  @OneToMany(mappedBy = "ticket")
    private List<Payment>paymentList;

    @ManyToMany
    private List<ShowSeat>showSeatList;
*/
}
