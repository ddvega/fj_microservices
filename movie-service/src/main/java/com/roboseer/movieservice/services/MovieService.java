package com.roboseer.movieservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.roboseer.movieservice.models.DiscoverMovies;
import com.roboseer.movieservice.models.GenreMap;
import com.roboseer.movieservice.models.Movie;
import com.roboseer.movieservice.repositories.MovieRepository;
import com.roboseer.movieservice.tmdb.TmdbApi;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
@Service
public class MovieService
{
    @Autowired
    private String getApiKey;
    private final MovieRepository movieRepository;
    private final GenreMap genreList = new GenreMap();

    public List<Movie> getAllMovies()
    {
        System.out.println("Api key is " + getApiKey);
        return movieRepository.findAll();
    }

    public Movie getMovieById(String id)
    {
        if (movieRepository.findById(id).isPresent())
        {
            return movieRepository.findById(id).get();
        }
        return null;
    }

    public Movie AddMovie(Movie payload) throws JsonProcessingException
    {
        Movie savedMovie = getMovieById(payload.getId());
        if (savedMovie != null)
        {
            // addListToMovie(payload, savedMovie);
            return savedMovie;
        } else
        {
            System.out.println("inserting movie " + payload);
            movieRepository.insert(payload);
        }

        return payload;
    }

    public List<Movie> searchMovies(Map<String, Object> payload) throws IOException
    {
        TmdbApi tmdbApi = new TmdbApi(getApiKey);
        DiscoverMovies newSearch = new DiscoverMovies();

        if (payload.containsKey("genre"))
        {
            System.out.println("Genre entered is " + payload.get("genre"));
            String genreId = genreList.findId(payload.get("genre").toString());
            System.out.println("Genre Id is " + genreId);
            newSearch.setGenre(genreId);
        }

        if (payload.containsKey("actor"))
        {
            System.out.println("Actor name entered is " + payload.get("actor"));
            String actorID = tmdbApi.getActorId(payload.get("actor").toString(), "1");
            newSearch.setActorId(actorID);
        }

        if (payload.containsKey("release_date_min"))
        {
            newSearch.setDateMIN(payload.get("release_date_min").toString());
        }

        if (payload.containsKey("release_date_max"))
        {
            newSearch.setDateMAX(payload.get("release_date_max").toString());
        }

        if (payload.containsKey("rating_min"))
        {
            newSearch.setRatingMIN(payload.get("rating_min").toString());
        }

        if (payload.containsKey("rating_max"))
        {
            newSearch.setRatingMAX(payload.get("rating_max").toString());
        }

        if (payload.containsKey("language"))
        {
            newSearch.setLanguage(payload.get("language").toString());
        }
        return tmdbApi.movieDiscover(newSearch);
    }
}
