package interfaces;

import java.util.List;

import entities.CarEntity;

public interface IVoiture {
	public List<CarEntity> getVoitures();
	
	public void addVoiture(CarEntity voiture);
	
	public void deleteVoiture(int id);
}
