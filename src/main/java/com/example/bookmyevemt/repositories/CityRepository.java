package com.example.bookmyevemt.repositories;

import com.example.bookmyevemt.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {


   @Override
   City save(City city); //UPSERT

   @Override
   Optional<City> findById(Long cityId);

   Optional<City> findByName(String name);


   @Override
   void deleteById(Long cityId);

   @Override
   boolean existsById(Long cityId);

   @Override
   List<City> findAll();

   @Override
   void deleteAll();


   @Override
   <S extends City> List<S> saveAll(Iterable<S> entities);
}
