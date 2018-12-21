package options;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.OptionsEntity;
import interfaces.IOption;

@Stateless
public class Options implements IOption {
    @PersistenceContext(name = "bdd")
    public EntityManager bd;
    
    private static final String SELECT_BY_NAME = "SELECT o FROM OptionsEntity o WHERE o.name=:name";
    private static final String NAME           = "name";

    @Override
    public void addOption(OptionsEntity option) {
        bd.persist(option);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OptionsEntity> getOption() {

    	System.out.println("ESSAIS");
        List<OptionsEntity> options = new ArrayList<>();
        options = (List<OptionsEntity>) bd.createQuery("SELECT o FROM OptionsEntity o").getResultList();
        return options;
    }
    
    @Override
    public OptionsEntity getOptionByName(String name) {

    	OptionsEntity option = null;
       
        
        Query requete = bd.createQuery(SELECT_BY_NAME);
        requete.setParameter(NAME, name);
        
        try {
            option = (OptionsEntity)requete.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return option;
    }

    @Override
    public void deleteOption(int id) {
        bd.createQuery("DELETE o From OptionsEntity o WHERE id=" + id).executeUpdate();
    }
}
