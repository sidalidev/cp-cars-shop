package type;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.TypeEntity;
import interfaces.IType;

@Stateless
public class Type implements IType {
    @PersistenceContext(name = "bdd")
    public EntityManager bd;
    
    private static final String SELECT_BY_NAME = "SELECT t FROM TypeEntity t WHERE t.name=:name";
    private static final String NAME           = "name";

    @Override
    public void addType(TypeEntity type) {
        bd.persist(type);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TypeEntity> getType() {

        List<TypeEntity> type = new ArrayList<>();
        type = (List<TypeEntity>)bd.createQuery("SELECT t FROM TypeEntity t").getResultList();
        return type;
    }
    
    @Override
    public TypeEntity getTypeByName(String name) {

    	TypeEntity type = null;
       
        
        Query requete = bd.createQuery(SELECT_BY_NAME);
        requete.setParameter(NAME, name);
        
        try {
            type = (TypeEntity)requete.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return type;
    }

    @Override
    public void deleteType(int id) {
        bd.createQuery("DELETE t From TypeEntity t WHERE id=" + id).executeUpdate();
    }
}

