package interfaces;

import java.util.List;

import entities.CartEntity;

public interface ICart {

	 public void addCart(CartEntity o);

	    public List<CartEntity> getCart();
	    
	    public CartEntity getOptionByUser(Integer id);
	    
	    public void editCart(CartEntity cart);

	    /*public void deleteCart(int id);
	    
	    public void updateCart(Integer id);*/
	        
}
