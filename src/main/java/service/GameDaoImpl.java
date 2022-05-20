package service;

import domain.game.Game;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("gameDao")
public class GameDaoImpl extends GenericDaoImpl<Game>  implements IGameDao{
	public GameDaoImpl() {
		super(Game.class);
	}

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Game> findAll() {
		TypedQuery<Game> query = em.createQuery(
				"SELECT g FROM Game g ORDER BY g.id",
				Game.class
		);
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Game> getGamesByStadium(String stadiumName) {
		return em
				.createNamedQuery("Game.getGamesByStadium", Game.class)
				.setParameter("name", stadiumName)
				.getResultList();
	}
}


