package com.example.bookmyevemt.models;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Access(AccessType.PROPERTY)

public class Actor extends BaseModel{
    @Column(name = "Name")
    private String name;

}
