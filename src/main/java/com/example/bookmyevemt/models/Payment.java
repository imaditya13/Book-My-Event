package com.example.bookmyevemt.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Access(AccessType.PROPERTY)
public class Payment extends BaseModel {
    /*@ManyToOne
    private Ticket ticket;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod paymentMethod;
*/
    private Date timeOfPayment;
    private double amount;
    private String referenceId;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

}
