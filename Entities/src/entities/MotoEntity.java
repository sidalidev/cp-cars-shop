package entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class MotoEntity extends VehiculeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public MotoEntity() {
		super();
	}
}
