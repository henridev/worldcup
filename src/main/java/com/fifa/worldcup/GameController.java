package com.fifa.worldcup;

import domain.TicketOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/game")
public class GameController {
	private TicketOrder ticketOrder;

	@Autowired
	public void setTicketOrder(TicketOrder ticketOrder) {
		this.ticketOrder = ticketOrder;
	}

	@GetMapping("/{stadium}")
	public String getGameOverview(@PathVariable String stadium) {
		return "game-overview";
	}

	@GetMapping("/{id}")
	public String getGameById(@PathVariable String id, Model model) {
		model.addAttribute("TicketOrder", ticketOrder);
		return "game-detail";
	}

	@PostMapping
	public String onSubmit(@Valid @ModelAttribute TicketOrder ticketOrder, BindingResult result, Model model) {
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
