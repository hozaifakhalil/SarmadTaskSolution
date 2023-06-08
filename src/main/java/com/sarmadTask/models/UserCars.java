package com.sarmadTask.models;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@Document(collection = "USER_CARS")
public class UserCars {

  @Field("USER_ID")
  public String userId;
  @Field("CAR_MODEL_ID")
  public String carModelId;
  @Id
  @Field("CAR_PLATE_NUMBER")
  public String carPlateNumber;
  @Field("COLOR")
  public String color;
    
}
