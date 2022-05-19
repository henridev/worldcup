package com.fifa.worldcup.controller;

import domain.country.Country;
import domain.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.IGameDao;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fifaDetail")
public class FifaRestController {
	private IGameDao gameDao;

	@Autowired
	public void setGameDao(IGameDao gameDao) {
		this.gameDao = gameDao;
	}

	@GetMapping(value = "/{id}")
	public List<String> getEmployee(@PathVariable("id") Long gameId) {
		return gameDao.get(gameId).getCountries().stream().map(Country::getName).collect(Collectors.toList());
	}
}
