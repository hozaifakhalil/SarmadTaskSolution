package com.sarmadTask.controllers;


import com.sarmadTask.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sarmadTask.auth.AuthenticationRequest;
import com.sarmadTask.auth.AuthenticationResponse;
import com.sarmadTask.auth.AuthenticationService;
import com.sarmadTask.auth.RegisterRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {


    private final UserService userService;

    @GetMapping("/getByName")
    public ResponseEntity findByFullName(@RequestBody String[] name){
        return ResponseEntity.ok().body(userService.findByFullName(name[0],name[1]));
    }

    @GetMapping("/getByNameAndPlateNumber")
    public ResponseEntity findByFullNameAndPlateNumber(@RequestBody String[] name){
        return ResponseEntity.ok().body(userService.findByFullNameAndPlateNumber(name[0],name[1],name[2]));
    }
  
}
