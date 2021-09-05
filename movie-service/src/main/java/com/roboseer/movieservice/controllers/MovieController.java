package com.roboseer.movieservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.roboseer.movieservice.models.Movie;
import com.roboseer.movieservice.services.MovieService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController
{

    private final MovieService movieService;

    @GetMapping
    public List<Movie> fetchAllMovies()
    {
        return movieService.getAllMovies();
    }

    @GetMapping("/search")
    public List<Movie> fetchAllMovies(@RequestBody Map<String, Object> payload) throws IOException
    {
        return movieService.searchMovies(payload);
    }

    //
    @PostMapping
    public Movie addMovie(@RequestBody Movie payload) throws JsonProcessingException
    {
        return movieService.AddMovie(payload);
    }
}
