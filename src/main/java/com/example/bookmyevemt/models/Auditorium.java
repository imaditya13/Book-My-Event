package com.example.bookmyevemt.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Setter
@Getter
@Entity
//@Access(AccessType.PROPERTY)

public class Auditorium extends BaseModel{
    @Column(name = "Name")
    private String name;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature>featureList;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "auditorium")
    private List<Seat>seatList;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id")
     private Theater theater;
}

//Audi : Seat
//1    :  M
//1    :  1

//Audi : Feature
//1    :  M
//M    :  M
