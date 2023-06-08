package com.sarmadTask.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarmadTask.services.UserCarService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class UserCarController {

    private final UserCarService userCarService;

    // @GetMapping("/name,{/name}")
    // public ResponseEntity<ResponseDto> getByName(@PathVariable String name) {

    //     userCarService

    // }
        
    // @GetMapping("/test")
    // public ResponseEntity<String> name() {

    //     return ResponseEntity.ok("wooooow");

        
    // }
    

    
    
}
