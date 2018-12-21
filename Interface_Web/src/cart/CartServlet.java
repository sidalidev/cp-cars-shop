package cart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entities.CartEntity;
import entities.TypeEntity;
import entities.UserEntity;
import entities.VehiculesEntity;
import interfaces.ICart;
import interfaces.IVehicules;
import user.Users;
import vehicules.Vehicules;
;

/**
 * Servlet implementation class User_Servlet
 */
@WebServlet("/Cart_Servlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public EntityManager bd;

    @EJB
    private ICart interCart;
    private IVehicules InterVehicule;
    

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String action = String.valueOf(request.getParameter("method"));
    	Integer user_id = Integer.valueOf(request.getParameter("user_id"));
    	Integer vehicule_id = Integer.valueOf(request.getParameter("vehicule_id"));
    	
    	CartEntity cart = interCart.getOptionByUser(user_id);
    	System.out.print(cart);
    	
    	
    	if(action=="GetAll") {
    		
    		List<CartEntity> cart2= interCart.getCart();
        	request.setAttribute("cart", cart2);
        	request.getRequestDispatcher("view-all-cart.jsp").forward(request, response);	
    	}
    	else {
    	
    	if(cart == null) {
    		
    	
    		Vehicules v = new Vehicules();
            VehiculesEntity vehicule = v.getVehiculeById(vehicule_id);
            
            
    		List<VehiculesEntity> list_vehicule = new ArrayList<>();
    		list_vehicule.add(vehicule);
    		
    		Users u = new Users();
            UserEntity user = u.getUserById(user_id);
            
    		   cart.setEnCours(true);
    		   cart.setUser(user);
    		   cart.setVehicules(list_vehicule);
    	       interCart.addCart(cart);
    	}
    	else {
    		Vehicules v = new Vehicules();
            VehiculesEntity vehicule = v.getVehiculeById(vehicule_id);
    		
    		List<VehiculesEntity> list_vehicule = cart.getVehicules();
    		list_vehicule.add(vehicule);
    		interCart.editCart(cart);
    	}
    	}	
    }
}

   

