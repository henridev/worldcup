package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StadiumService  implements IStadiumService{
	private final List<String> stadiumList;

	public StadiumService() {
		stadiumList = new ArrayList<>(Arrays.asList("Al Bayt Stadium", "Al Thumama Stadium"));
	}

	public List<String> getStadiumList() {
		return stadiumList;
	}
}
