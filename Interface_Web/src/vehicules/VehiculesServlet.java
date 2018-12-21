package vehicules;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.OptionsEntity;
import entities.TypeEntity;
import entities.VehiculesEntity;
import interfaces.IOption;
import interfaces.IType;
import interfaces.IVehicules;
import options.Options;


/**
 * Servlet implementation class User_Servlet
 */
@WebServlet("/Vehicule_Servlet")
public class VehiculesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IVehicules interVehicule;
    private IOption interOption;
    private IType interType;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehiculesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

String action = String.valueOf(request.getParameter("method"));

    	

    	if (action.equals("getAll")) {
    		List<VehiculesEntity> vehicules = interVehicule.getVehicule();
        	request.setAttribute("vehicule", vehicules);
        	request.getRequestDispatcher("view-vehicules.jsp").forward(request, response);	
    	}
    	else {
    		Integer id = Integer.valueOf(request.getParameter("id"));
    		VehiculesEntity vehicules = interVehicule.getVehiculeById(id);
        	request.setAttribute("vehicule_id", vehicules);
        	request.getRequestDispatcher("view-one-vehicules.jsp").forward(request, response);	
    	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = String.valueOf(request.getParameter("name"));
        Float price = Float.valueOf(request.getParameter("price"));
        System.out.println(price);
        Integer quantity = Integer.valueOf(request.getParameter("quantity"));
        String[] options = request.getParameterValues("options");
        String[] types = request.getParameterValues("type");
        
        String type = types[0];
        
        TypeEntity new_type = new TypeEntity();
        new_type.setName(type);

        List<OptionsEntity> listOptions = new ArrayList<>();
        
        /* voir pour add options qui existe */
        for (int i = 0; i < options.length; i++) {
        	OptionsEntity o = new OptionsEntity();
			o.setName(options[i]);
			listOptions.add(o);
        }

       
        VehiculesEntity vehicule = new VehiculesEntity();
        
        vehicule.setName(name);
        vehicule.setPrice(price);
        vehicule.setQuantity(quantity);
        vehicule.setOption(listOptions);
        vehicule.setType(new_type);
        
        System.out.println(vehicule.getOption().size());

        interVehicule.addVehicule(vehicule);
        request.setAttribute("vehicule", vehicule);
        request.getRequestDispatcher("add-vehicules.jsp").forward(request, response);
    }

}