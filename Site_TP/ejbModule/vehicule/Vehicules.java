package vehicule;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.VehiculeEntity;
import interfaces.IVehicule;

@Stateless
public class Vehicules implements IVehicule{
	@PersistenceContext(name ="testbdd")
	private EntityManager em;
	
	@Override
	public VehiculeEntity getVehicule(int id) {
		
		return (VehiculeEntity)em.createQuery("Select v FROM Vehicule_entity v WHERE id ="+id).getSingleResult();
	}
}
