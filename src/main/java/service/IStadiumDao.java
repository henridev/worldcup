package service;

import domain.stadium.Stadium;

import java.util.List;

public interface IStadiumDao extends IGenericDao<Stadium> {
	public List<Stadium> getStadiumByName(String name);
}