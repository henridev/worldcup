package com.fifa.worldcup.controller;

import domain.TicketOrderForm;
import domain.country.Country;
import domain.game.Game;
import domain.stadium.Stadium;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import service.IGameDao;
import service.TicketService;
import validator.TicketFormValidator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GameControllerTest {
	@Autowired
	private WebApplicationContext wac;
	private GameController controller;

	private MockMvc mockMvc;

	@Mock
	private IGameDao mock;

	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.openMocks(this);
		controller = new GameController();
		controller.setTicketService(new TicketService());
		controller.setTicketFormValidator(new TicketFormValidator());
		mockMvc = standaloneSetup(controller).build();
	}

//	@BeforeAll
//	public void beforeAll() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//	}

	@Test
	@WithMockUser(username = "user", password = "12345678", roles = "USER")
	public void testGameOverview() throws Exception {
		mockMvc.perform(post("/game").param("stadiumSelected", "Al Janoub Stadium"))
				.andExpect(status().isOk())
				.andExpect(view().name("game/game-overview"))
				.andExpect(model().attributeExists("stadium"))
				.andExpect(model().attributeExists("games"));
	}


	@Test
	@WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
	public void testGameDetail() throws Exception {
		Mockito.when(mock.get(1L)).thenReturn(createGame());

		ReflectionTestUtils.setField(controller, "gameDao", mock);

		mockMvc.perform(get("/game/1"))
				.andExpect(status().isOk())
				.andExpect(view().name("game/game-ticket-form"))
				.andExpect(model().attributeExists("ticketOrderForm"))
				.andExpect(model().attributeExists("gameID"))
				.andExpect(model().attributeExists("game"));
	}

	@Test
	@WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
	public void testTicketOrder() throws Exception {


		Mockito.when(mock.update(createGame())).thenReturn(createGame());

		TicketService ticketSerivce = new TicketService();
		ReflectionTestUtils.setField(ticketSerivce, "gameDao", mock);
		controller.setTicketService(ticketSerivce);


		mockMvc.perform(post("/game/{id}", 1L)
						.sessionAttr("ticketOrderForm", createForm())
						.flashAttr("game", createGame())
						.flashAttr("gameID", 1)
				)
				.andExpect(view().name("redirect:/fifa?sold=1"));
	}

	private Game createGame(){
		Stadium stadium = new Stadium();
		stadium.setCapacity(100);
		stadium.setName("ABC");
		stadium.setLocation("ABC");

		Country countryA = new Country();
		Country countryB = new Country();
		countryA.setName("A");
		countryB.setName("B");

		List<Country> countries = List.of(new Country[]{countryA, countryB});

		Game game = new Game(
				1L,
				stadium,
				countries,
				LocalDate.now(),
				LocalTime.now(),
				10
		);

		return game;
	}

	private TicketOrderForm createForm(){
		TicketOrderForm form = new TicketOrderForm();
		form.setEmail("henri.dbel@gmail.com");
		form.setTickets(1);
		form.setSoccerCode1(1);
		form.setSoccerCode2(2);
		return form;
	}
}