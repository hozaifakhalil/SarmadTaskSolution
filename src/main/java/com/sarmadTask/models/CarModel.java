package com.sarmadTask.models;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document(collection = "CAR_MODELS")
public class CarModel {
   @Id
   public String carModelId;
   public String modelName;
   public String type;
   public String manufacturerYear;
   
}
