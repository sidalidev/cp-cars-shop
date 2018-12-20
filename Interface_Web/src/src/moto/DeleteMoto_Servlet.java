package src.moto;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.IMoto;

@WebServlet("/DeleteMoto_Servlet")
public class DeleteMoto_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private IMoto interMoto;
	
    public DeleteMoto_Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id  = Integer.valueOf(request.getParameter("id"));
		
		try{
			interMoto.deleteMoto(id);
		}catch(Exception e) {
			String error = "Erreur lors de la suppression de la moto d'id : " + id;
			request.setAttribute("error", error);
			request.getRequestDispatcher("Get_content.jsp").forward(request, response);
		}
		String message = "Moto "+id +" supprim�e";
		request.setAttribute("message", message);
		request.getRequestDispatcher("Get_content.jsp").forward(request, response);
	}

}
