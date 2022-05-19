package service;

import domain.game.Game;
import domain.stadium.Stadium;

import java.util.List;

public interface IGameDao extends IGenericDao<Game> {
	public List<Game> getGamesByStadium(String stadiumName);
}