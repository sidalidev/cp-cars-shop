package type;
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


import entities.TypeEntity;
import entities.OptionsEntity;
import interfaces.IType;
import options.Options;
import interfaces.IOption;

/**
 * Servlet implementation class User_Servlet
 */
@WebServlet("/Type_Servlet")
public class TypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public EntityManager bd;

    @EJB
    private IType interType;
    private IOption interOptions;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeServlet() {
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
    	

    	if (action.equals("getAll")) {
    		List<TypeEntity> type = interType.getType();
    		String test = "toto";
    		
    		
			
    		request.setAttribute("type", type);
        	request.setAttribute("test", test);
        	
        	List<OptionsEntity> options = new ArrayList<>();
            options = (List<OptionsEntity>) bd.createQuery("SELECT o FROM OptionsEntity o").getResultList();
            System.out.println(options);
            
            request.setAttribute("options", options);
        	
        	
        	request.getRequestDispatcher("add-vehicules.jsp").forward(request, response);
        	  
    	}
    	else {
    	List<TypeEntity> type = interType.getType();
    	request.setAttribute("type", type);
    	request.getRequestDispatcher("view-type.jsp").forward(request, response);
    	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	
        String name = String.valueOf(request.getParameter("name"));
        System.out.print(name);
        TypeEntity type = new TypeEntity();
        type.setName(name);

        interType.addType(type);
        request.setAttribute("type", type);
        request.getRequestDispatcher("addType.jsp").forward(request, response);
    }
    
   

}
