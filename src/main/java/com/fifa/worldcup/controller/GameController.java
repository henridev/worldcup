package com.fifa.worldcup.controller;

import domain.TicketOrderForm;
import domain.stadium.StadiumCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import validator.SoccerCodesValidation;

import javax.validation.Valid;
import java.util.Date;

@Controller
@SessionAttributes("stadium")
@RequestMapping("/game")
public class GameController {
	private TicketOrderForm ticketOrderForm;
	private SoccerCodesValidation soccerCodesValidation;

	@Autowired
	public void setSoccerCodesValidation(SoccerCodesValidation soccerCodesValidation){
		this.soccerCodesValidation = soccerCodesValidation;
	}

	@Autowired
	public void setTicketOrder(TicketOrderForm ticketOrderForm) {
		this.ticketOrderForm = ticketOrderForm;
	}

	@GetMapping
	public String getGameOverview(@ModelAttribute StadiumCommand stadiumCommand, Model model) {
		model.addAttribute("stadium", stadiumCommand.getStadiumSelected());
		return "game/game-overview";
	}

	@GetMapping("/{id}")
	public String getGameById(@PathVariable String id, Model model) {
		// set default values
		ticketOrderForm.setSoccerCode1(1);
		ticketOrderForm.setSoccerCode2(25);
		model.addAttribute("TicketOrder", ticketOrderForm);
		model.addAttribute("today", new Date());

		return "game/game-detail";
	}

	@PostMapping
	public String onSubmit(@Valid @ModelAttribute TicketOrderForm ticketOrderForm, BindingResult result, Model model) {
		soccerCodesValidation.validate(ticketOrderForm.getSoccerCodes(), result);
//		BankCustomer currentCustomer =  bankCustomerLookup.getCustomer(bankCustomer.getId());
//
//		if (currentCustomer == null)
//			return "unknownCustomer";
//
//		model.addAttribute("customer", currentCustomer);
//
//		if (currentCustomer.getBalance() < 0)
//			return "negativeBalance";
//
//		return "balance";
		return "redirect:/fifa";
	}
}
