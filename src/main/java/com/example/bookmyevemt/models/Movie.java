package com.example.bookmyevemt.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Access(AccessType.PROPERTY)
public class Movie extends BaseModel{
    private String name;

   @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Genre> genres;


    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Language> languages;

   /* @ManyToMany
    private List<Actor>actorList;*/
}
