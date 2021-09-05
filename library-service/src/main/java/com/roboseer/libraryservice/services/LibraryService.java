package com.roboseer.libraryservice.services;

import com.roboseer.libraryservice.VO.User;
import com.roboseer.libraryservice.models.Library;
import com.roboseer.libraryservice.repositories.LibraryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class LibraryService
{
    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Library AddLibrary(Library library)
    {
//        User savedUser = getUserById(user.getId());
//        if (savedUser != null)
//        {
//            return savedUser;
//        }
        log.info("Inside AddLibrary of LibraryService");
        String url = "http://USER-SERVICE/user/" + library.getUserId() + "/library/" + library.getId();
//        Map<String, String> params = new HashMap<String, String>();
//        params.put(library.getUserId(), library.getId());
//        restTemplate.put(url,params);
        restTemplate.put(url, null);


        libraryRepository.save(library);
        return library;
    }

    public List<Library> getUserLibraries(String userId)
    {
        log.info("Inside GetUserLibraries of LibraryService");
        return libraryRepository.getAllByUserId(userId);
    }

    public String deleteLibrary(String libraryId)
    {
        log.info("Inside deleteLibrary of LibraryService");
        Library library = libraryRepository.findLibraryById(libraryId);
        String url = "http://USER-SERVICE/user/" + library.getUserId() + "/library/" + libraryId;
        restTemplate.delete(url);
        libraryRepository.delete(library);
        return "Library with id " + libraryId + " has been deleted";

    }
}
