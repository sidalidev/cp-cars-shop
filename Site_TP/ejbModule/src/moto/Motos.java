package src.moto;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Moto_entity;
import interfaces.IMoto;

@Stateless
public class Motos implements IMoto{
	@PersistenceContext(name="testbdd")
	public EntityManager em;

	@Override
	public void addMoto(Moto_entity moto) {
		em.persist(moto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Moto_entity> getMotos() {

		List<Moto_entity> motos = new ArrayList<>();
		motos = (List<Moto_entity>)em.createQuery("select m from Moto_entity m").getResultList();

		return motos;
	}

	@Override
	public void deleteMoto(int id) {
		em.createQuery("DELETE m From Moto_entity m WHERE id="+id).executeUpdate();
	}
}
