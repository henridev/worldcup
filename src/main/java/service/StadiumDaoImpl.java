package service;

import domain.stadium.Stadium;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("stadiumDao")
public class StadiumDaoImpl extends GenericDaoImpl<Stadium>  implements IStadiumDao{
	public StadiumDaoImpl() {
		super(Stadium.class);
	}

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Stadium> findAll() {
		TypedQuery<Stadium> query = em.createQuery(
				"SELECT s FROM Stadium s ORDER BY s.name",
				Stadium.class
		);
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Stadium> getStadiumByName(String name) {
		return em
				.createNamedQuery("Stadium.getStadiumByName", Stadium.class)
				.setParameter("name", name)
				.getResultList();

	}
}


