package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class OtherEntity extends VehiculeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public OtherEntity() {
		super();
	}

}
