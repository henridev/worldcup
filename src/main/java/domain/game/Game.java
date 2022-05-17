package domain.game;

public class Game {
	private String id; //unieke sleutel
	private String[] countries; //2 countries van de game
	private int day; //day van de game
	private int hour; //hour van de game

	public Game() {}

	public Game(String id, String[] countries, int day, int hour) {
		this.id = id;
		this.countries = countries;
		this.day = day;
		this.hour = hour;
	}

	public String getId() {
		return id;
	}
	public String[] getCountries() {
		return countries;
	}
	public int getDay() {
		return day;
	}
	public int getHour() {
		return hour;
	}
	@Override
	public String toString() {
		return String.format("%s vs %s on %d-11", countries[0], countries[1], day);
	}
}
