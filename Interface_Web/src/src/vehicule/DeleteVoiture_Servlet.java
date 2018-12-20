package src.vehicule;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.IVoiture;

@WebServlet("/DeleteVoiture_Servlet")
public class DeleteVoiture_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private IVoiture interVoiture;
	
    public DeleteVoiture_Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		
		try{
			interVoiture.deleteVoiture(id);
		}catch(Exception e) {
			String error = "Erreur lors de la suppression de la voiture d'id : " + id;
			request.setAttribute("error", error);
			request.getRequestDispatcher("Get_content.jsp").forward(request, response);
		}
		String message = "Voiture "+id +" supprim�e";
		request.setAttribute("message", message);
		request.getRequestDispatcher("Get_content.jsp").forward(request, response);
	}

}
