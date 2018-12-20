package other;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.OtherEntity;
import interfaces.IAutre;

@Stateless
public class Autres implements IAutre{

	@PersistenceContext(name="testbdd")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OtherEntity> listerAutresVehicules() {

		List<OtherEntity> autresVehicules = new ArrayList<>();
		autresVehicules = (List<OtherEntity>)em.createQuery("select a from Autre_entity a").getResultList();

		return autresVehicules;
	}

	@Override
	public void addAutreVehicule(OtherEntity autre) {
		em.persist(autre);
	}
}
