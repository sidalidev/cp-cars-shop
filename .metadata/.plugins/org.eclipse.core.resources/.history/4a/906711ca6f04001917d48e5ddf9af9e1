package src.vehicule;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Vehicule_entity;
import interfaces.IVehicule;

@Stateless
public class Vehicules implements IVehicule{
	@PersistenceContext(name ="testbdd")
	private EntityManager em;
	
	@Override
	public Vehicule_entity getVehicule(int id) {
		
		return (Vehicule_entity)em.createQuery("Select v FROM Vehicule_entity v WHERE id ="+id).getSingleResult();
	}
}
