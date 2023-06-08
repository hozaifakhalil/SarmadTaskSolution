package com.sarmadTask.services;

import java.util.ArrayList;
import java.util.List;

import com.sarmadTask.models.CarModel;
import com.sarmadTask.models.Users;

import lombok.RequiredArgsConstructor;

import com.sarmadTask.models.UserCars;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DataFill {

  // private final PasswordEncoder passwordeEncoder;

  public List<Users> UserGenerator()
  {
    List<Users> Users=new ArrayList<Users>();
    for (int i=0;i<1000000;i++)
    {
        Users user = new Users( Integer.toString(i), "User"+i, "lastName"+i, "1"+i, "123"+i);
        Users.add(user);
    }
    return Users;
  }   

  public List<CarModel> CarModelGenerator()
  {
    List<CarModel> carModels=new ArrayList<CarModel>();
        CarModel carModel = new CarModel("1", "Lanser", "Hachback", "2018");
        carModels.add(carModel);
        CarModel carModel1 = new CarModel("2", "BMW", "Hachback", "2022");
        carModels.add(carModel1);
        CarModel carModel2 = new CarModel("3", "BMW", "sedan", "2011");
        carModels.add(carModel2);
        CarModel carModel3 = new CarModel("4", "marcedes", "Hachback", "2013");
        carModels.add(carModel3);
        CarModel carModel4 = new CarModel("5", "marcedes", "sedan", "2015");
        carModels.add(carModel4);
        CarModel carModel5 = new CarModel("6", "hyndai", "Hachback", "2009");
        carModels.add(carModel5);
        CarModel carModel6 = new CarModel("7", "hyndai", "sedan", "2001");
        carModels.add(carModel6);
        CarModel carModel7 = new CarModel("8", "honda", "Hachback", "2005");
        carModels.add(carModel7);
        CarModel carModel8 = new CarModel("9", "honda", "sedan", "2014");
        carModels.add(carModel8);
        CarModel carModel9 = new CarModel("10", "ferarri", "sedan", "2012");
        carModels.add(carModel9);
        CarModel carModel10 = new CarModel("11", "jaguar", "Hachback", "2011");
        carModels.add(carModel10);
        CarModel carModel11 = new CarModel("12", "jaguar", "sedan", "2019");
        carModels.add(carModel11);
        CarModel carModel12 = new CarModel("13", "nissan", "Hachback", "2021");
        carModels.add(carModel12);
        CarModel carModel13 = new CarModel("14", "nissan", "sedan", "2012");
        carModels.add(carModel13);
        CarModel carModel14 = new CarModel("15", "Lanser", "sedan", "2011");
        carModels.add(carModel14);
    
    return carModels;
  } 
   public List<UserCars> UserCarsGenerator()
  {
    List<UserCars> userCars=new ArrayList<UserCars>();
    for (int i=0;i<200;i++)
    {
        UserCars userCar = new UserCars(Integer.toString(i), Integer.toString(i), "234"+i, "RED");
        userCars.add(userCar);
    }
    return userCars;
  } 
}
