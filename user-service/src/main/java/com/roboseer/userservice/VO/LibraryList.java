package com.roboseer.userservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class LibraryList
{
    private List<Library> libraryList;

    public LibraryList()
    {
        libraryList = new ArrayList<>();
    }
}
