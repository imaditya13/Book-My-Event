package com.example.bookmyevemt.services;

import com.example.bookmyevemt.Exception.AuditoriumNotFoundException;
import com.example.bookmyevemt.Exception.TheaterIdNotFoundException;
import com.example.bookmyevemt.dto.AuditoriumRequestDto;
import com.example.bookmyevemt.models.Auditorium;
import com.example.bookmyevemt.models.Theater;
import com.example.bookmyevemt.repositories.AuditoriumRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuditoriumService {
    TheaterService theaterService;
    AuditoriumRepository auditoriumRepository;
    @Autowired
    public AuditoriumService(TheaterService theaterService, AuditoriumRepository auditoriumRepository)
    {
        this.auditoriumRepository = auditoriumRepository;
        this.theaterService = theaterService;
    }
    public Auditorium createAudiById(AuditoriumRequestDto requestDto) throws TheaterIdNotFoundException {
       Long theaterId = requestDto.getTheaterId();
        Theater theater = theaterService.getTheaterById(theaterId);
        if(theater==null)throw new TheaterIdNotFoundException(theaterId);

        Auditorium auditorium = convertToAudi(requestDto,theater);
        auditoriumRepository.save(auditorium);
        return auditorium;
    }
    public Auditorium getAudiById(Long audiId) throws AuditoriumNotFoundException {
        Optional<Auditorium> auditorium = auditoriumRepository.findById(audiId);
        if(auditorium.isEmpty())throw  new AuditoriumNotFoundException(audiId);

        return auditorium.get();
    }
    public List<Auditorium> getAllAudis()
    {
        return auditoriumRepository.findAll();
    }
    public void deleteAudiById(Long audiId) throws AuditoriumNotFoundException {
        if(auditoriumRepository.existsById(audiId))
        {
            auditoriumRepository.deleteById(audiId);
        }
        else throw new AuditoriumNotFoundException(audiId);
    }

    private Auditorium convertToAudi(AuditoriumRequestDto requestDto, Theater theater) {
        Auditorium auditorium = new Auditorium();
        auditorium.setName(requestDto.getName());
        auditorium.setFeatureList(requestDto.getFeatures());
        auditorium.setTheater(theater);
        return auditorium;
    }
}
