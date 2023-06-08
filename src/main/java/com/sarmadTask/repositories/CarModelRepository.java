package com.sarmadTask.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sarmadTask.models.CarModel;

public interface CarModelRepository extends MongoRepository<CarModel,String> {
    
}
