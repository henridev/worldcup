package com.fifa.worldcup.controller;

import domain.TicketOrderForm;

import domain.game.Game;
import domain.stadium.StadiumCommand;
import exceptions.CustomGenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IGameDao;
import utils.Message;
import validator.TicketFormValidator;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@SessionAttributes({"gameId","ticketOrderForm", "game"})
@RequestMapping("/game")
public class GameController {
	private IGameDao gameDao;
	private TicketFormValidator ticketFormValidator;
	private MessageSource messageSource;

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Autowired
	public void setTicketFormValidator(TicketFormValidator ticketFormValidator) {
		this.ticketFormValidator = ticketFormValidator;
	}

	@Autowired
	public void setGameDao(IGameDao gameDao) {
		this.gameDao = gameDao;
	}


	@PostMapping
	public String getGameOverview(@ModelAttribute StadiumCommand stadiumCommand, Model model) {
		model.addAttribute("stadium", stadiumCommand.getStadiumSelected());
		model.addAttribute("games", gameDao.getGamesByStadium(stadiumCommand.getStadiumSelected()));
		return "game/game-overview";
	}

	@GetMapping("/{id}")
	public String getGameById(@PathVariable Long id, Model model) {
		Game game = gameDao.get(id);

		if(checkSoldOut(game)){
			return "redirect:/fifa" + "?soldOut=true";
		}

		// set default values
		TicketOrderForm form = new TicketOrderForm();

		form.setTickets(1);
		form.setSoccerCode1(10);
		form.setSoccerCode2(25);

		model.addAttribute("ticketOrderForm", form);
		model.addAttribute("game", game);
		model.addAttribute("gameID", id);

		return "game/game-ticket-form";
	}

	@PostMapping("/{id}")
	public String onSubmit(
			@ModelAttribute Game game,
			@Valid @ModelAttribute TicketOrderForm ticketOrder,
			BindingResult result,
			@PathVariable Long id,
			Locale locale
	) {
		ticketFormValidator.validate(ticketOrder, result);

		if(result.hasErrors()){
			return "game/game-ticket-form";
		}

		try{
			buyTickets(game, ticketOrder.getTickets(), locale);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/fifa" + "?sold=" + ticketOrder.getTickets();
	}

	public void buyTickets(Game game, Integer toBuy, Locale locale) {
		int ticketsLeft = game.getStadium().getCapacity() - game.getBoughtTickets();

		//Nog voldoende tickets
		if (ticketsLeft >= toBuy) {
			game.setBoughtTickets(game.getBoughtTickets() + toBuy);
			gameDao.update(game);
			return;
		}

		String message = messageSource.getMessage(
				"tickets_sold_out",
				new Object[]{},
				locale
		);

		throw new CustomGenericException("ERR1", message);
	}
	public boolean checkSoldOut(Game game) {
		int ticketsLeft = game.getStadium().getCapacity() - game.getBoughtTickets();
		return ticketsLeft == 0;
	}

	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {
		ModelAndView model = new ModelAndView("error/generic-error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());
		return model;
	}
}
