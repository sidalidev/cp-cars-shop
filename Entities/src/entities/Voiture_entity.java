package entities;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: voiture
 *
 */
@Entity
public class Voiture_entity extends Vehicule_entity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Voiture_entity() {
		super();
	}
   
}
