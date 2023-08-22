package com.example.bookmyevemt.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Access(AccessType.PROPERTY)
@Table(name = "show_seat_mapping")
public class ShowSeat extends BaseModel{
  /*  @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;*/

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;

}
