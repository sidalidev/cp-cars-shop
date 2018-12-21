package user;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.UserEntity;
import interfaces.IUser;

@Stateless
public class Users implements IUser {
	
	@PersistenceContext(name="bdd")
	public EntityManager em;

    private static final String SELECT_BY_EMAIL = "SELECT u FROM UserEntity u WHERE u.email=:email";
    private static final String EMAIL           = "email";
    
    private static final String SELECT_BY_ID = "SELECT u FROM UserEntity u WHERE u.id=:id";
    private static final String ID          = "id";

    
    public void addUser(UserEntity user) {
    	em.persist(user);
    }


    public UserEntity getUser(String email) {
        UserEntity utilisateur = null;

        Query requete = em.createQuery(SELECT_BY_EMAIL);
        requete.setParameter(EMAIL, email);
        
        try {
            utilisateur = (UserEntity)requete.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        
        return utilisateur;
    }
    
    public UserEntity getUserById(Integer id) {
    	
    	 UserEntity utilisateur = null;

         Query requete = em.createQuery(SELECT_BY_ID);
         requete.setParameter(ID, id);
         
         try {
             utilisateur = (UserEntity)requete.getSingleResult();
         } catch (NoResultException e) {
             return null;
         }
         
         return utilisateur;
    }
    
}