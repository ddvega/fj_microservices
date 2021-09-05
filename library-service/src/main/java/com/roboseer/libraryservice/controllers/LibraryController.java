package com.roboseer.libraryservice.controllers;

import com.roboseer.libraryservice.models.Library;
import com.roboseer.libraryservice.services.LibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@Slf4j
public class LibraryController
{
    @Autowired
    LibraryService libraryService;

    @PostMapping("/")
    public Library addLibrary(@RequestBody Library library)
    {
        log.info("Inside addLibrary of LibraryController");
        return libraryService.AddLibrary(library);
    }

    @GetMapping("/{id}")
    public List<Library> getUserLibraries(@PathVariable ("id") String userId)
    {
        log.info("Inside getUserLibraries of LibraryController");
        return libraryService.getUserLibraries(userId);
    }

    @DeleteMapping("/{libraryId}")
    public String deleteLibrary(@PathVariable(name = "libraryId") String libraryId)
    {
        return libraryService.deleteLibrary(libraryId);
    }

}
