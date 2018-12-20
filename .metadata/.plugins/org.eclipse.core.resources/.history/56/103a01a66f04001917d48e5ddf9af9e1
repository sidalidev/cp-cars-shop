package src.autre;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Autre_entity;
import interfaces.IAutre;

@Stateless
public class Autres implements IAutre{

	@PersistenceContext(name="testbdd")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Autre_entity> listerAutresVehicules() {

		List<Autre_entity> autresVehicules = new ArrayList<>();
		autresVehicules = (List<Autre_entity>)em.createQuery("select a from Autre_entity a").getResultList();

		return autresVehicules;
	}

	@Override
	public void addAutreVehicule(Autre_entity autre) {
		em.persist(autre);
	}
}
