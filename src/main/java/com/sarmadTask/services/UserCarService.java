package com.sarmadTask.services;

import com.sarmadTask.models.UserCars;
import org.springframework.stereotype.Service;
import com.sarmadTask.repositories.UsersCarRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCarService {
    private final UsersCarRepository usersCarRepository;


 
}
