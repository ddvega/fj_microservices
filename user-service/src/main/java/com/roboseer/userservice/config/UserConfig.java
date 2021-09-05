package com.roboseer.userservice.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import roboseer.flickjunkies.repositories.FlickListRepository;
import com.roboseer.userservice.repositories.UserRepository;

@Configuration
public class UserConfig
{
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository)
    {
        return args ->
        {
//            User mariam = new User("bob3456");
//            User alex = new User("alex65324");
//            userRepository.saveAll(List.of(mariam, alex));
//            FlickList flist = new FlickList("quaranflicks");
//            flickListRepository.save(flist);
//            FlickList horrorList = new FlickList("besthorror");
//            flickListRepository.save(horrorList);

//            User storedUser = userRepository.findByUsername("bob3456").get();
//            FlickList storedList = flickListRepository.findByName("quaranflicks").get();
//            FlickList horrorList = flickListRepository.findByName("besthorror").get();
//            System.out.println("Stored user is " + storedUser.getUsername());
//            System.out.println("Stored list is " + storedList.getName());

//            storedUser.getFlickLists().add(horrorList.getId());
//            userRepository.save(storedUser);
//            List<String> userList = storedUser.getFlickLists();
//            Iterable<FlickList> ulist= flickListRepository.findAllById(userList);
//            System.out.println(ulist);

//            // add list to user
//            storedUser.getFlickLists().add(storedList.getId());
//            userRepository.save(storedUser);

//            System.out.println(storedUser.getFlickLists());


//             // Get user by id
//            User storedUser = userRepository.findById("6123ff02c7e742115bac7266").get();
//            System.out.println("The stored user's name is " + storedUser.getUsername());
//
//            // get list by id
//            FlickList storedList = flickListRepository.findById("6123ff02c7e742115bac7268").get();
//            System.out.println("The FlickList name is " + storedList.getName());

//           ObjectId id = new ObjectId("6123ff02c7e742115bac7268");
//            storedUser.getFlickLists().add(id);
//            userRepository.save(storedUser);

//            System.out.println(userRepository.findByFlickListsContains(id));

//
            // assign list to user
//            System.out.println(storedUser.getFlickLists().toString());
            // userRepository.save(storedUser);

//            flickListRepository.removeFlickListById("6123f069056db75f23a56325");
        };
    }
}

