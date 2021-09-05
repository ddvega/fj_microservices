package com.roboseer.movieservice.models;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@NoArgsConstructor
public class Movie
{
    @Id
    private String id;
    private String title;
    private String overview;
    private String vote_average;
    private String original_language;
    private List<Integer> genre_ids;
    private String poster_path;
    private String backdrop_path;
    private String release_date;

    @Override
    public String toString()
    {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", vote_average='" + vote_average + '\'' +
                ", original_language='" + original_language + '\'' +
                ", genre_ids=" + genre_ids +
                ", poster_path='" + poster_path + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", release_date='" + release_date + '\'' +
                '}';
    }

    public String toJson()
    {
        // convert array of integers to JsonElement
        JsonElement genreList = new GsonBuilder().create().toJsonTree(this.genre_ids);

        // Build Json Object
        JsonObject movieJson = new JsonObject();
        movieJson.addProperty("id", this.id);
        movieJson.add("genre_ids", genreList);
        movieJson.addProperty("title", this.title);
        movieJson.addProperty("release_date",this.overview);
        movieJson.addProperty("vote_average", this.vote_average);
        movieJson.addProperty("original_language",this.original_language);
        movieJson.addProperty("overview",this.overview);
        movieJson.addProperty("poster_path",this.poster_path);
        movieJson.addProperty("backdrop_path", this.id);

        return movieJson.toString();
    }
}
