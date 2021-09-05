package com.roboseer.movieservice.tmdb;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import com.roboseer.movieservice.models.DiscoverMovies;
import com.roboseer.movieservice.models.GenreMap;
import com.roboseer.movieservice.models.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TmdbApi
{
    private String apiKey;
    public GenreMap genreList = new GenreMap();


    public String getActorId(String searchVal, String page) throws IOException
    {
        String query =
                "https://api.themoviedb.org/3/search/person?api_key="
                        + apiKey + "&language=en-US&query="
                        + searchVal + "&page="
                        + page + "&include_adult=false";

        JSONObject result = queryApi(query);
        JSONArray res = (JSONArray) result.get("results");
        JSONObject results = (JSONObject) res.get(0);
        return results.get("id").toString();
    }

    public List<Movie> movieDiscover(DiscoverMovies searchData) throws IOException
    {
        if (searchData.getTitle() != null)
        {
            // do a different search and exit
            return null;
        }

        String query = "https://api.themoviedb.org/3/discover/movie?api_key=" + apiKey + "&sort_by" +
                "=popularity.desc&include_adult=false&include_video=false&page=" + searchData.getPage();

        // rating minimum
        if (searchData.getRatingMIN() != null)
        {
            query = query + "&vote_average.gte=" + searchData.getRatingMIN();
        }

        // rating maximum
        if (searchData.getRatingMAX() != null)
        {
            query = query + "&vote_average.lte=" + searchData.getRatingMAX();
        }

        // actor
        if (searchData.getActorId() != null)
        {
            query = query + "&with_people=" + searchData.getActorId();
        }

        // release date minimum
        if (searchData.getDateMIN() != null)
        {
            query = query + "&primary_release_date.gte=" + searchData.getDateMIN();
        }

        // release date max
        if (searchData.getDateMAX() != null)
        {
            query = query + "&primary_release_date.lte=" + searchData.getDateMAX();
        }

        // genre
        if (searchData.getGenre() != null)
        {
            query = query + "&with_genres=" + searchData.getGenre();
        }

        // original language
        if (searchData.getLanguage() != null)
        {
            query = query + "&with_original_language=" + searchData.getLanguage();
        }

        JSONObject result = queryApi(query);
        JSONArray res = (JSONArray) result.get("results");


        // List of Movie objects
        List<Movie> movieList = new ArrayList<>();

        // map json object to movie class
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);

        // Loop through TMDB api response and create list of movie objects using object mapper
        for (int i = 0; i < res.length(); i++)
        {
            Movie movie = objectMapper.readValue(res.get(i).toString(), Movie.class);
            movieList.add(movie);
        }

        return movieList;

    }

    private JSONObject queryApi(String queryString) throws IOException
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(queryString).build();
        Response response = client.newCall(request).execute();
        String jsonData = response.body().string();
        return new JSONObject(jsonData);
    }

    public TmdbApi(String apiKey)
    {
        this.apiKey = apiKey;
    }
}
