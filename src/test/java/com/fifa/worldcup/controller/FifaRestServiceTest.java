package com.fifa.worldcup.controller;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public class FifaRestServiceTest {
		private final String SERVER_URI = "http://localhost:8080/fifaDetail";
		private WebClient webClient = WebClient.create();

		public FifaRestServiceTest() {
			System.out.println("------- GET 1 ------- ");
			getGameCountries(1);
			System.out.println("\n------- GET 2 ------- ");
			getGameCountries(2);
		}

		private void getGameCountries(long id) {
			List<String> countries = webClient.get().uri(SERVER_URI + id).retrieve().bodyToMono(List.class).block();
			assert countries != null;
			printCountriesData(countries);
		}


		private void printCountriesData(List<String> countries) {
			countries.forEach(System.out::println);
		}
}
