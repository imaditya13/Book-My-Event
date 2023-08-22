package com.example.bookmyevemt.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Access(AccessType.PROPERTY)

public class ShowSeatType extends BaseModel {
   /* @ManyToOne
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;*/

    private Double price;
}
