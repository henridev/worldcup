package com.fifa.worldcup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String showHomePage() {
		return "redirect:/fifa";
	}
}
