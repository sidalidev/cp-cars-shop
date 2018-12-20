package moto;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.MotoEntity;
import interfaces.IMoto;

@Stateless
public class Motos implements IMoto{
	@PersistenceContext(name="testbdd")
	public EntityManager em;

	@Override
	public void addMoto(MotoEntity moto) {
		em.persist(moto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MotoEntity> getMotos() {

		List<MotoEntity> motos = new ArrayList<>();
		motos = (List<MotoEntity>)em.createQuery("select m from Moto_entity m").getResultList();

		return motos;
	}

	@Override
	public void deleteMoto(int id) {
		em.createQuery("DELETE m From Moto_entity m WHERE id="+id).executeUpdate();
	}
}
