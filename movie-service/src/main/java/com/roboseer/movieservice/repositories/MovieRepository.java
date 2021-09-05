package com.roboseer.movieservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.roboseer.movieservice.models.Movie;

import java.util.Optional;

public interface MovieRepository extends MongoRepository<Movie, String>
{
    Optional<Movie> findMoviesByTitle(String title);
}
