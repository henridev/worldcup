package com.fifa.worldcup;

import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import service.*;
import domain.TicketOrderForm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import validator.TicketFormValidator;

import java.util.Properties;

@SpringBootApplication
public class ApplicationWorldCup implements WebMvcConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationWorldCup.class, args);
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

	@Bean
	public TicketService ticketService() {
		TicketService ticketService = new TicketService();
		ticketService.setMessageSource(messageSource());
		ticketService.setGameDao(gameDao());
		return ticketService;
	}

	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
		CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
		loggingFilter.setIncludeClientInfo(true);
		loggingFilter.setIncludeQueryString(true);
		loggingFilter.setIncludePayload(true);
		loggingFilter.setMaxPayloadLength(64000);
		return loggingFilter;
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
	public TicketFormValidator ticketFormValidator() {
		return new TicketFormValidator();
	}

	/*
	 *	SERVICES
	 */

	@Bean
	public IStadiumDao stadiumDao() {
		return new StadiumDaoImpl();
	}

	@Bean
	public IGameDao gameDao() {
		return new GameDaoImpl();
	}

	/*
	 *	POJO'S
	 */

	@Bean
	public TicketOrderForm ticketOrderForm() {
		return new TicketOrderForm();
	}


	/*
	 *	STATIC PAGES
	 */

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/403").setViewName("error/403");
	}
}
