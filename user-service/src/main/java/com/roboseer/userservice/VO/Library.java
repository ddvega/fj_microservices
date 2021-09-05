package com.roboseer.userservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Library
{
    private String id;
    private String name;
    private String userId;
    private List<String> movies;
}

//    @Id
//    private String id;
//    @Indexed(unique = true)
//    private String name;
//    private String userId;
//    private List<String> movies;

