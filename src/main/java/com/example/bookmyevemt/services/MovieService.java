package com.example.bookmyevemt.services;

import com.example.bookmyevemt.Exception.ActorNotFoundException;
import com.example.bookmyevemt.Exception.MovieNotFoundException;
import com.example.bookmyevemt.dto.ActorRequestDto;
import com.example.bookmyevemt.dto.MovieRequestDto;
import com.example.bookmyevemt.models.Actor;
import com.example.bookmyevemt.models.Movie;
import com.example.bookmyevemt.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    MovieRepository movieRepository;
    ActorService actorService;
    @Autowired
    public MovieService(MovieRepository movieRepository,ActorService actorService)
    {
        this.movieRepository = movieRepository;
        this.actorService = actorService;
    }
    public Movie createMovie(MovieRequestDto requestDto) throws ActorNotFoundException {
        List<Actor>actors = new ArrayList<>();
        List<Long>actorsIds = requestDto.getActorIds();
        for (Long actorID : actorsIds) {

            Actor actor = actorService.getActorById(actorID);
            if(actor==null)throw new ActorNotFoundException(actorID);

            actors.add(actor);
        }
        Movie movie = convertToMovie(requestDto,actors);

        return movieRepository.save(movie);
    }

    public void deleteMovieById(Long movieId) throws MovieNotFoundException {
        if(movieRepository.existsById(movieId))
        {
            movieRepository.deleteById(movieId);
        }
        else throw new MovieNotFoundException(movieId);
    }

    public Movie getMovieById(Long movieId) throws MovieNotFoundException {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if(movie.isEmpty())throw new MovieNotFoundException(movieId);

        return movie.get();
    }
   public List<Movie> getAllMovies()
   {
       return movieRepository.findAll();
   }
    private Movie convertToMovie(MovieRequestDto requestDto,List<Actor>actors) {
        Movie movie = new Movie();
        movie.setName(requestDto.getName());
        movie.setFeatures(requestDto.getFeatures());
        movie.setGenres(requestDto.getGenres());
        movie.setLanguages(requestDto.getLanguages());
        movie.setActorList(actors);
        return movie;
    }
}
