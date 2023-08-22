package com.example.bookmyevemt.models;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Access(AccessType.PROPERTY)
public class User extends BaseModel{

    private String email;
}
