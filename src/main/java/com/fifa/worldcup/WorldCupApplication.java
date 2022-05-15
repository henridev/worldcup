package com.fifa.worldcup;

import domain.IStadiumService;
import domain.StadiumService;
import domain.TicketOrder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import validator.SoccerCodesValidation;

import java.util.Properties;

@SpringBootApplication
public class WorldCupApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(WorldCupApplication.class, args);
	}

	/*
	 *	CONFIG
	 */

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("resources/img/");
		registry.addResourceHandler("/css/**").addResourceLocations("resources/css/");
	}

	@Bean public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	/*
	 *	EXCEPTIONS
	 */

	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();

		Properties mappings = new Properties();
		mappings.put(
				"java.lang.NumberFormatException",
				"error/generic_error"
		);

		r.setDefaultErrorView("error/error");
		r.setExceptionMappings(mappings);
		return r;
	}

	/*
	 *	VALIDATIONS
	 */
	@Bean
	public SoccerCodesValidation soccerCodesValidation() {
		return new SoccerCodesValidation();
	}

	/*
	 *	SERVICES
	 */
	@Bean
	public IStadiumService stadiumService() {
		return new StadiumService();
	}


	/*
	 *	POJO'S
	 */
	@Bean
	public TicketOrder ticketOrder() {
		return new TicketOrder();
	}
}
