package src.voitures;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Voiture_entity;
import interfaces.IVoiture;

//Ici on implémente les fonctions et méthodes qui agiront avec les entities définies dans le projet JPA

@Stateless
public class Voitures implements IVoiture {
	@PersistenceContext(name="testbdd")
	public EntityManager em;

	@Override
	public void addVoiture(Voiture_entity voiture) {
		
		em.persist(voiture);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture_entity> getVoitures() {
		
		List<Voiture_entity> vehicules = new ArrayList<>();
		vehicules = (List<Voiture_entity>)em.createQuery("select v from Voiture_entity v").getResultList();
		
		return vehicules;
	}


	@Override
	public void deleteVoiture(int id) {
		em.createQuery("DELETE v From Voiture_entity v WHERE id="+id).executeUpdate();
	}
}