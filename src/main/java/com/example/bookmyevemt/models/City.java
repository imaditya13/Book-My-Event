package com.example.bookmyevemt.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter

public class City extends BaseModel{
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "city")
    private List<Theater>theaterList;
}
/*
City - Theatre
1 ----- M
1 ----- 1
 */