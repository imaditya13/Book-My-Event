package com.example.bookmyevemt.repositories;

import com.example.bookmyevemt.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {
    List<ShowSeat> findAllByIdIn(List<Long> showSeatIds);

    @Lock(LockModeType.PESSIMISTIC_READ)
    default List<ShowSeat> findAllByIdInAndShowSeatStatusAvailable(List<Long> showSeatIds) {
        return null;
    }

    @Override
    ShowSeat save(ShowSeat showSeat); //UPSERT
}
