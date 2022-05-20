package domain.stadium;


import domain.game.Game;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
	@NamedQuery(
		name= "Stadium.getStadiumByName",
		query = "SELECT s FROM Stadium s WHERE s.name = :name"
	)
})
public class Stadium implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
	private String name;
	@OneToMany(mappedBy = "stadium")
	private List<Game> games;
	private String location;
	private Integer capacity;

	public Stadium() {}

	public Stadium(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}


	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stadium other = (Stadium) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return String.format("%s ", name);
	}
}
