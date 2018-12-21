package vehicules;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.OptionsEntity;
import entities.VehiculesEntity;
import interfaces.IVehicules;

@Stateless
public class Vehicules implements IVehicules {
    @PersistenceContext(name = "bdd")
    public EntityManager bd;
    
    private static final String SELECT_BY_ID = "SELECT v FROM VehiculesEntity v WHERE v.id=:id";
    private static final String ID          = "id";

    @Override
    public void addVehicule(VehiculesEntity type) {
        bd.persist(type);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<VehiculesEntity> getVehicule() {

        List<VehiculesEntity> vehicule = new ArrayList<>();
        vehicule = (List<VehiculesEntity>) bd.createQuery("select v from VehiculesEntity v").getResultList();
        return vehicule;
    }
    
    public VehiculesEntity getVehiculeById(Integer id) {
	VehiculesEntity vehicule = null;
       
        
        Query requete = bd.createQuery(SELECT_BY_ID);
        requete.setParameter(ID, id);
        
        try {
            vehicule = (VehiculesEntity)requete.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return vehicule;
    }

    @Override
    public void deleteVehicule(int id) {
        bd.createQuery("DELETE v From VehiculeEntity v WHERE id=" + id).executeUpdate();
    }
}

