package domain.country;

import domain.game.Game;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String name;
	private String grouping;
	@ManyToMany(mappedBy = "countries")
	private List<Game> games;

	protected Country() {}

	public Country(String name, String grouping, List<Game> games) {
		this.name = name;
		this.grouping = grouping;
		this.games = games;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public String getGrouping() {
		return grouping;
	}

	public void setGrouping(String group) {
		this.grouping = group;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
