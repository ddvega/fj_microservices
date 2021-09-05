package com.roboseer.userservice.services;

import com.roboseer.userservice.VO.Library;
import com.roboseer.userservice.VO.LibraryList;
import com.roboseer.userservice.VO.ResponseTemplateVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
// import com.roboseer.userservice.models.FlickList;
import com.roboseer.userservice.models.User;
// import com.roboseer.userservice.repositories.FlickListRepository;
import com.roboseer.userservice.repositories.UserRepository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    // private final FlickListRepository flickListRepository;

//    public Iterable<FlickList> getUserLists(String username)
//    {
//        User storedUser = userRepository.findByUsername(username).get();
//        List<String> userList = storedUser.getFlickLists();
//        return flickListRepository.findAllById(userList);
//    }

    public User getUserById(String id)
    {
        if (userRepository.findById(id).isPresent())
        {
            return userRepository.findById(id).get();
        }
        return null;
    }

    public User AddUser(User user)
    {
        User savedUser = getUserById(user.getId());
        if (savedUser != null)
        {
            return savedUser;
        }
        userRepository.save(user);
        return user;
    }

    public User addLibraryToUser(String userId, String libraryId)
    {
        User user = userRepository.findUserById(userId);
        List<String> libraryList = user.getLibrary();
        libraryList.add(libraryId);
        user.setLibrary(libraryList);
        userRepository.save(user);
        return user;
    }

    public ResponseTemplateVO getUserWithLibrary(String userId)
    {
        log.info("Inside getUserWithLibrary of UserService");
        System.out.println("user id is " + userId);

        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findUserById(userId);
        ResponseEntity<Library[]> response = restTemplate.getForEntity("http://LIBRARY-SERVICE/library/" + userId,
                Library[].class);
        Library[] libraryList = response.getBody();
        vo.setUser(user);
        assert libraryList != null;
        vo.setLibraryList(List.of(libraryList));
        return vo;


    }

    public User deleteLibraryFromUser(String userId, String libraryId)
    {
        User user = getUserById(userId);
        List<String> libraryList = user.getLibrary();
        libraryList.remove(libraryId);
        user.setLibrary(libraryList);
        userRepository.save(user);

        return user;
    }
}
