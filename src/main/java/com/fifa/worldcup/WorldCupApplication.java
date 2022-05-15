package com.fifa.worldcup;

import domain.IStadiumService;
import domain.StadiumService;
import domain.TicketOrder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WorldCupApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(WorldCupApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("resources/img/");
		registry.addResourceHandler("/css/**").addResourceLocations("resources/css/");
	}


	@Bean
	public IStadiumService stadiumService() {
		return new StadiumService();
	}

	@Bean
	public TicketOrder ticketOrder() {
		return new TicketOrder();
	}
}
