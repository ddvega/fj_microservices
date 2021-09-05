package com.roboseer.libraryservice.repositories;

import com.roboseer.libraryservice.models.Library;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository extends MongoRepository<Library, String>
{
    Optional<Library> removeLibrariesById(String id);
    List<Library> getAllByUserId(String userId);
    Library findLibraryById(String libraryId);
}
