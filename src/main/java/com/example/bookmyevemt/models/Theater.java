package com.example.bookmyevemt.models;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Getter
@Setter
//@Access(AccessType.PROPERTY)
public class Theater extends BaseModel{
     String name;
     String adress;

   /* @ManyToOne
    private City city;
    */

//    @JdbcTypeCode(SqlTypes.JSON)
//    @Column(columnDefinition="JSON")
    @OneToMany(mappedBy = "theater")
     List<Auditorium> auditoriumList;

}
