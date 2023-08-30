package com.example.bookmyevemt.services;

import com.example.bookmyevemt.Exception.CityNotFoundException;
import com.example.bookmyevemt.Exception.TheaterIdNotFoundException;
import com.example.bookmyevemt.dto.TheaterRequestDto;
import com.example.bookmyevemt.models.City;
import com.example.bookmyevemt.models.Theater;
import com.example.bookmyevemt.repositories.TheaterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TheaterService {
    TheaterRepository theaterRepository;
    CityService cityService;
    @Autowired
    public TheaterService(TheaterRepository theaterRepository,CityService cityService)
    {
        this.theaterRepository =theaterRepository;
        this.cityService = cityService;
    }

    public Theater createTheater(TheaterRequestDto requestDto) throws CityNotFoundException {
        City city = cityService.getCityById(requestDto.getCityId());
        if(city==null)throw new CityNotFoundException(requestDto.getCityId());

        Theater theater = convertToTheater(requestDto,city);
        return theaterRepository.save(theater);
    }
    public Theater getTheaterById(Long theaterId) throws TheaterIdNotFoundException {
        Optional<Theater> theater = theaterRepository.findById(theaterId);
        if(theater.isEmpty())throw  new TheaterIdNotFoundException(theaterId);
        return theater.get();
    }
    public List<Theater> getAllTheaters()
    {
        return theaterRepository.findAll();
    }
    public void deleteById(Long id) throws TheaterIdNotFoundException {

        if(theaterRepository.existsById(id))
        {
            theaterRepository.deleteById(id);
        }
        else  throw new TheaterIdNotFoundException(id);

    }

    private Theater convertToTheater(TheaterRequestDto requestDto, City city) {
        Theater theater = new Theater();
        theater.setName(requestDto.getName());
        theater.setAdress(requestDto.getAddress());
        theater.setCity(city);
        return  theater;
    }
}
