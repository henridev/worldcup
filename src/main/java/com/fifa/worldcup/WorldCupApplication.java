package com.fifa.worldcup;

import domain.IStadiumService;
import domain.StadiumService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorldCupApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldCupApplication.class, args);
	}

	@Bean
	public IStadiumService stadiumService() {
		return new StadiumService();
	}

}
