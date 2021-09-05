package com.roboseer.movieservice.models;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GenreMap
{
    private Map<String, String> name2id = new HashMap<>();
    private Map<String, String> id2name;

    public GenreMap()
    {
        this.name2id.put("Action", "28");
        this.name2id.put("Adventure", "12");
        this.name2id.put("Animation", "16");
        this.name2id.put("Comedy", "35");
        this.name2id.put("Crime", "80");
        this.name2id.put("Documentary", "99");
        this.name2id.put("Drama", "18");
        this.name2id.put("Family", "10751");
        this.name2id.put("Fantasy", "14");
        this.name2id.put("History", "36");
        this.name2id.put("Horror", "27");
        this.name2id.put("Music", "10402");
        this.name2id.put("Mystery", "9648");
        this.name2id.put("Romance", "10749");
        this.name2id.put("Science Fiction", "878");
        this.name2id.put("TV Movie", "10770");
        this.name2id.put("Thriller", "53");
        this.name2id.put("War", "10752");
        this.name2id.put("Western", "37");

        id2name = name2id.entrySet().stream()
                        .collect(Collectors.toMap(Map.Entry::getValue,Map.Entry::getKey));
    }

    public String findId(String name)
    {
        try
        {
            return name2id.get(name);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public String findName(int id)
    {
        try
        {
            return id2name.get(id);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


}
