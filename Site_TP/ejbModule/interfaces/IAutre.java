package interfaces;

import java.util.List;

import entities.OtherEntity;

public interface IAutre {
	public List<OtherEntity> listerAutresVehicules();
	
	public void addAutreVehicule(OtherEntity autre);
}
