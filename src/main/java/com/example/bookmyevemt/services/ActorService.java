package com.example.bookmyevemt.services;

import com.example.bookmyevemt.Exception.ActorNotFoundException;
import com.example.bookmyevemt.dto.ActorRequestDto;
import com.example.bookmyevemt.models.Actor;
import com.example.bookmyevemt.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    ActorRepository actorRepository;
    @Autowired
    public ActorService(ActorRepository actorRepository)
    {
        this.actorRepository = actorRepository;
    }
    public Actor createActor(ActorRequestDto requestDto)
    {
        Actor actor = convertToActor(requestDto);

        return actorRepository.save(actor);
    }
    public void deleteById(Long actorId) throws ActorNotFoundException {
        if(actorRepository.existsById(actorId))
        {
             actorRepository.deleteById(actorId);
        }
        else throw new ActorNotFoundException(actorId);
    }

    public Actor getActorById(Long actorId) throws ActorNotFoundException {
        Optional<Actor> actor = actorRepository.findById(actorId);
        if(actor.isEmpty())throw new ActorNotFoundException(actorId);

        return actor.get();
    }
    public List<Actor> getAllActors()
    {
        return actorRepository.findAll();
    }
    private Actor convertToActor(ActorRequestDto requestDto) {
        Actor actor = new Actor();
        actor.setName(requestDto.getName());
        return actor;
    }
}
