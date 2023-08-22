package com.example.bookmyevemt.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@Access(AccessType.PROPERTY)

public class City extends BaseModel{
    private String name;
/*
    @OneToMany(mappedBy = "city")
    @Column(name = "theaater-list-id")
    private List<Theater>theaterList;*/
}
/*
City - Theatre
1 ----- M
1 ----- 1
 */