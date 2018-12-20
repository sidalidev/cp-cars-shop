package car;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.CarEntity;
import interfaces.IVoiture;

//Ici on impl�mente les fonctions et m�thodes qui agiront avec les entities d�finies dans le projet JPA

@Stateless
public class Voitures implements IVoiture {
	@PersistenceContext(name="testbdd")
	public EntityManager em;

	@Override
	public void addVoiture(CarEntity voiture) {
		
		em.persist(voiture);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CarEntity> getVoitures() {
		
		List<CarEntity> vehicules = new ArrayList<>();
		vehicules = (List<CarEntity>)em.createQuery("select v from Voiture_entity v").getResultList();
		
		return vehicules;
	}


	@Override
	public void deleteVoiture(int id) {
		em.createQuery("DELETE v From Voiture_entity v WHERE id="+id).executeUpdate();
	}
}