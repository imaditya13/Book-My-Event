package com.example.bookmyevemt.models;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Getter
@Setter
public class Theater extends BaseModel{
    private String name;
   private   String adress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;


//    @JdbcTypeCode(SqlTypes.JSON)
//    @Column(columnDefinition="JSON")
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "theater",fetch = FetchType.LAZY)
    @Transient
    private List<Auditorium> auditoriumList;

}
