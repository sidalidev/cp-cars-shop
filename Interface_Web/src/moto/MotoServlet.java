package moto;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.MotoEntity;
import interfaces.IMoto;

@WebServlet("/Moto_Servlet")
public class MotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IMoto inter;

	public MotoServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MotoEntity> motos = inter.getMotos();

		request.setAttribute("vehicules", motos);
		request.getRequestDispatcher("Get_content.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String marque = String.valueOf(request.getParameter("marque"));
		String modele = String.valueOf(request.getParameter("modele"));
		String prix = String.valueOf(request.getParameter("prix"));
		String description = String.valueOf(request.getParameter("description"));

		MotoEntity m = new MotoEntity();
		m.setMarque(marque);
		m.setModele(modele);
		m.setPrix(prix);
		m.setDescription(description);
		inter.addMoto(m);

		request.setAttribute("m", m);
		request.getRequestDispatcher("Added_page.jsp").forward(request, response);
	}

}
