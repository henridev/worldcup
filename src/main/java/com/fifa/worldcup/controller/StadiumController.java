package com.fifa.worldcup.controller;

import domain.stadium.Stadium;
import domain.stadium.StadiumCommand;
import domain.stadium.StadiumForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IStadiumDao;

import java.util.List;

@Controller
@RequestMapping("/fifa")
public class StadiumController {
	private IStadiumDao stadiumDao;

	@Autowired
	public void setStadiumDao(IStadiumDao stadiumDao) {
		this.stadiumDao = stadiumDao;
	}

	@ModelAttribute("stadiumList")
	public List<Stadium> populateStadiums() {
		return stadiumDao.findAll();
	}

	@GetMapping
	public String showHomePage(Model model, @RequestParam(required = false) String sold, @RequestParam(required = false) boolean soldOut) {
		System.out.println("home");
		StadiumForm stadiumForm = new StadiumForm();
		stadiumForm.setStadiums(stadiumDao.findAll());
		model.addAttribute("sold", sold);
		model.addAttribute("soldOut", soldOut);
		model.addAttribute("stadiumForm", stadiumForm);
		model.addAttribute("stadiumCommand", new StadiumCommand());
		return "home-page";
	}
}
