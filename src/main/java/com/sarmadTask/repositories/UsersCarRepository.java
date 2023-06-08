package com.sarmadTask.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sarmadTask.models.UserCars;

import java.util.List;

public interface UsersCarRepository extends MongoRepository<UserCars,String> {
   List<UserCars> findAllByUserId(String id);
}
