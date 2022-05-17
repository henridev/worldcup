package service;

import domain.stadium.Stadium;

import java.util.ArrayList;
import java.util.List;

public class StadiumServiceImpl implements IStadiumService {
	private static List<Stadium> stadiumList = new ArrayList<>();


	static {
		stadiumList.add(new Stadium("Al Thumama Stadium"));
    	stadiumList.add(new Stadium("Al Bayt Stadium"));
	}

	@Override
	public List<Stadium> findAll() {
		return stadiumList;
	}

}
