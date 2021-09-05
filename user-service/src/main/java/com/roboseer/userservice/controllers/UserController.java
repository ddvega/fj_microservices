package com.roboseer.userservice.controllers;

import com.roboseer.userservice.VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.roboseer.userservice.models.User;
import com.roboseer.userservice.services.UserService;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController
{
    @Autowired
    private UserService userService;

//    // @GetMapping("/{id}/lists")
//    // need to change this to to userid instead of username
//    @GetMapping("/{username}/lists")
//    public Iterable<FlickList> fetchUsersLists(@PathVariable String username)
//    {
//        return userService.getUserLists(username);
//    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String userId)
    {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}/library/{libraryId}")
    public User addLibraryToUser(@PathVariable(name = "userId") String userId,
                                 @PathVariable(name = "libraryId") String libraryId)
    {
        return userService.addLibraryToUser(userId, libraryId);
    }

    @DeleteMapping("/{userId}/library/{libraryId}")
    public User deleteLibraryFromUser(@PathVariable(name = "userId") String userId,
                                        @PathVariable(name = "libraryId") String libraryId){
        return userService.deleteLibraryFromUser(userId, libraryId);
    }

    @PostMapping("/")
    public User addUser(@RequestBody User payload)
    {
        log.info("Inside addUser of UserController");
        return userService.AddUser(payload);
    }

    @GetMapping("/{id}/library")
    public ResponseTemplateVO getUserWithLibrary(@PathVariable("id") String userId)
    {
        log.info("Inside getUserWithLibrary of UserController");
        return userService.getUserWithLibrary(userId);
    }


}
