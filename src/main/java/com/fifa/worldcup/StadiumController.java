package com.fifa.worldcup;

import domain.IStadiumService;
import domain.StadiumCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/fifa")
public class StadiumController {
	private IStadiumService stadiumService;

	@Autowired
	public void setStadiumBean(IStadiumService stadiumService) {
		this.stadiumService = stadiumService;
	}

	@ModelAttribute("stadiumList")
	public List<String> populateStadiums() {
		return stadiumService.getStadiumList();
	}

	@GetMapping
	public String showHomePage(Model model) {
		model.addAttribute("stadiumCommand", new StadiumCommand());
		return "home-page";
	}
}
