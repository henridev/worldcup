package domain.game;

import domain.country.Country;
import domain.stadium.Stadium;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@NamedQueries({
		@NamedQuery(
				name= "Game.getGamesByStadium",
				query = "SELECT g FROM Game g WHERE g.stadium.name = :name"
		)
})
public class Game implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Stadium stadium;
	@ManyToMany
	private List<Country> countries;
	@Column(columnDefinition = "DATE")
	private LocalDate date;
	@Column(columnDefinition = "TIME")
	private LocalTime time;
	@Column(columnDefinition = "int(11) default 0")
	private int boughtTickets;

	public Game() {}

	public Game(Long id, Stadium stadium, List<Country> countries, LocalDate date, LocalTime time, int boughtTickets) {
		this.id = id;
		this.stadium = stadium;
		this.countries = countries;
		this.date = date;
		this.time = time;
		this.boughtTickets = boughtTickets;
	}
	public Game(Stadium stadium, List<Country> countries, LocalDate date, LocalTime time, int boughtTickets) {
		this.stadium = stadium;
		this.countries = countries;
		this.date = date;
		this.time = time;
		this.boughtTickets = boughtTickets;
	}


	public Long getId() {
		return id;
	}

	public int getBoughtTickets() {
		return boughtTickets;
	}

	public void setBoughtTickets(int boughtTickets) {
		this.boughtTickets = boughtTickets;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	public List<Country> getCountries() {
		return countries;
	}

	public String getCountriesNames() {
		return  countries.stream().map(Country::getName).collect(Collectors.joining("-"));
	}

	public Stadium getStadium() {
		return stadium;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return String.format("%s vs %s on %s", getCountries().get(0), getCountries().get(1), date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}
}
