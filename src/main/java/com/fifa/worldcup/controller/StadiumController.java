package com.fifa.worldcup.controller;

import domain.stadium.Stadium;
import domain.stadium.StadiumForm;
import service.IStadiumService;
import domain.stadium.StadiumCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/fifa")
public class StadiumController {
	private IStadiumService stadiumService;

	@Autowired
	public void setStadiumService(IStadiumService stadiumService) {
		this.stadiumService = stadiumService;
	}

	@ModelAttribute("stadiumList")
	public List<Stadium> populateStadiums() {
		return stadiumService.findAll();
	}

	@GetMapping
	public String showHomePage(Model model) {
		StadiumForm stadiumForm = new StadiumForm();
		stadiumForm.setStadiums(stadiumService.findAll());
		model.addAttribute("stadiumForm", stadiumForm);
		model.addAttribute("stadiumCommand", new StadiumCommand());
		return "home-page";
	}


	@PostMapping
	public String onSubmit(@ModelAttribute StadiumCommand stadiumCommand, Model model) {
		model.addAttribute("stadium", stadiumCommand.getStadiumSelected());
		return "game/game-overview";
	}
}
