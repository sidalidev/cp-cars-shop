package entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class CarEntity extends VehiculeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public CarEntity() {
		super();
	}

}
