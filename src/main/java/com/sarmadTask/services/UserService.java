package com.sarmadTask.services;

import com.sarmadTask.models.Users;
import com.sarmadTask.models.UserCars;
import com.sarmadTask.repositories.UserRepository;
import com.sarmadTask.repositories.UsersCarRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Data
@Service
public class UserService {
    private final UserRepository userRepository;

    private final UsersCarRepository usersCarRepository;


    public List<UserCars> findByFullName(String firstName, String secondName){
        Users currentUser = userRepository.findByFullName(firstName,secondName);
        return usersCarRepository.findAllByUserId(currentUser.userId);
    }
    public UserCars findByFullNameAndPlateNumber(String firstName, String secondName,String plateNumber){
        Users currentUser = userRepository.findByFullName(firstName,secondName);
        List<UserCars> s = usersCarRepository.findAllByUserId(currentUser.userId).stream().filter(object-> object.carPlateNumber.equals(plateNumber)).collect(Collectors.toList());
        return s.get(0);
    }
}
