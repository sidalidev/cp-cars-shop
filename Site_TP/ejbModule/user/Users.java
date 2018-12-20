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
	
	@PersistenceContext(name="testbdd")
	public EntityManager em;

    private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM User_entity u WHERE u.email=:email";
    private static final String PARAM_EMAIL           = "email";

    // Enregistrement d'un nouvel utilisateur
    public void addUser(UserEntity user) {
    	em.persist(user);
    }


    // Recherche d'un utilisateur � partir de son adresse email
    public UserEntity getUser(String email) {
        UserEntity utilisateur = null;

        Query requete = em.createQuery(JPQL_SELECT_PAR_EMAIL);
        requete.setParameter(PARAM_EMAIL, email);
        
        try {
            utilisateur = (UserEntity)requete.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        
        return utilisateur;

    }

}