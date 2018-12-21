package cart;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.CartEntity;
import interfaces.ICart;

@Stateless
public class Cart implements ICart {
    @PersistenceContext(name = "bdd")
    public EntityManager bd;
    
    private static final String SELECT_BY_ID_USER_By_Boolean = "SELECT c FROM CartEntity c WHERE c.user.id=:id and encours=false";
    private static final String ID           = "id";

    @Override
    public void addCart(CartEntity cart) {
        bd.persist(cart);
    }

    public void editCart(CartEntity cart) {
    	bd.merge(cart);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<CartEntity> getCart() {

        List<CartEntity> cart = new ArrayList<>();
        cart = (List<CartEntity>) bd.createQuery("SELECT c FROM CartEntity c").getResultList();
        return cart;
    }
    
    @Override
    public CartEntity getOptionByUser(Integer id) {
    	
    	CartEntity cart = null;
       
        
        Query requete = bd.createQuery(SELECT_BY_ID_USER_By_Boolean);
        requete.setParameter(ID, id);
        
        try {
            cart = (CartEntity)requete.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return cart;
    	
    }

}
