package com.sarmadTask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.cache.annotation.EnableCaching;

import com.sarmadTask.auth.AuthenticationService;
import com.sarmadTask.auth.RegisterRequest;
import com.sarmadTask.repositories.CarModelRepository;
import com.sarmadTask.repositories.UserRepository;
import com.sarmadTask.repositories.UsersCarRepository;
import com.sarmadTask.services.DataFill;

@SpringBootApplication
// @EnableCaching
public class SarmadTaskApplication implements CommandLineRunner {

	@Autowired
	UserRepository userReposatory;
	@Autowired
	CarModelRepository carModelRepository;
	@Autowired
	UsersCarRepository usersCarRepository;
	@Autowired
	DataFill dataFill;
	@Autowired
	AuthenticationService authenticationService;

	public static void main(String[] args) {
		SpringApplication.run(SarmadTaskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		usersCarRepository.saveAll(dataFill.UserCarsGenerator());
		carModelRepository.saveAll(dataFill.CarModelGenerator());
		authenticationService.register(dataFill.UserGenerator());
	}

}
