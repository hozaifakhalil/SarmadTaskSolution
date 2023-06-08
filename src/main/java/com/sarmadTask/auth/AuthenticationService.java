package com.sarmadTask.auth;

import com.sarmadTask.models.Users;
import com.sarmadTask.repositories.UserRepository;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sarmadTask.config.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = Users.builder()
                .userId(request.getUserId())
                .firstName(request.getFirstName())
                .secondName(request.getSecondName())
                .userId(request.getUserId())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        if (repository.findById(user.getUserId()).isPresent()) {
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .mssg("user is already exist")
                    // .token(jwtToken)
                    .build();
        }
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .mssg("signed-up successfully")
                .token(jwtToken)
                .build();

    }

    public void register(List<Users> users) {
        for (var user : users) {
            user = Users.builder()
                    .userId(user.getUserId())
                    .firstName(user.getFirstName())
                    .secondName(user.getSecondName())
                    .userId(user.getUserId())
                    .password(passwordEncoder.encode(user.getPassword()))
                    .build();
            repository.save(user);
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserId(), request.getPassword()));
        var user = repository.findById(request.getUserId()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .mssg("loged-in successfully")
                .build();
    }
}
