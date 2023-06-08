package com.sarmadTask.repositories;

import java.util.List;
import java.util.Optional;

import com.sarmadTask.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<Users,String> {

    Optional<Users> findById(String id);
    // Optional<USERS> findByFristName(String )

    // @Query("db.USER_CARS.find({'USER_ID':db.USERS.findOne({})})")
   

    @Query(value = "{'firstName': ?0,'secondName': ?1}")
    Users findByFullName(String firstName,String secondName);
    
}
