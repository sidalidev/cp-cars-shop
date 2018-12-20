package vehicule;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.VehiculeEntity;
import interfaces.IVehicule;

@WebServlet("/Vehicule_Servlet")
public class VehiculeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IVehicule interVehicule;

	public VehiculeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		VehiculeEntity ve = interVehicule.getVehicule(id);
		request.setAttribute("vehicule", ve);
		request.getRequestDispatcher("vehiculeDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
