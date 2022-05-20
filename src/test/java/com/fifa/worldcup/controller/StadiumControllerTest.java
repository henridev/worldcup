package com.fifa.worldcup.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StadiumControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@BeforeAll
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testGameOverview() throws Exception {

		mockMvc.perform(get("/fifa"))
				.andExpect(view().name("home-page"))
				.andExpect(model().attributeExists("stadiumCommand"))
				.andExpect(model().attributeExists("stadiumForm"));
	}
}