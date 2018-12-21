package interfaces;
import java.util.List;

import entities.VehiculesEntity;

public interface IVehicules {
    public void addVehicule(VehiculesEntity v);

    public List<VehiculesEntity> getVehicule();

    public void deleteVehicule(int id);
    
    public VehiculesEntity getVehiculeById(Integer id);
}
