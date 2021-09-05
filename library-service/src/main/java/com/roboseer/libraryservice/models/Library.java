package com.roboseer.libraryservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Library
{
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String userId;
    private List<String> movies;

    public Library(String name)
    {
        this.name = name;
    }
}
