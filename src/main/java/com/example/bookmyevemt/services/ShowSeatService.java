package com.example.bookmyevemt.services;

import com.example.bookmyevemt.models.ShowSeat;
import com.example.bookmyevemt.repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowSeatService {
    ShowSeatRepository showSeatRepository;
    @Autowired
    public ShowSeatService(ShowSeatRepository showSeatRepository)
    {
        this.showSeatRepository = showSeatRepository;
    }
    public List<ShowSeat> getseatsByIds(List<Long>showSeatIds)
    {
        return showSeatRepository.findAllByIdIn(showSeatIds);
    }
    public List<ShowSeat> getseatsByIdWithLock(List<Long>showSeatIds)
    {
        return showSeatRepository.findAllByIdInAndShowSeatStatusAvailable(showSeatIds);
    }
    public void saveShowSeat(ShowSeat showSeat)
    {
        showSeatRepository.save(showSeat);
    }
}
