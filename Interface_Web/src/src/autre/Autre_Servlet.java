package src.autre;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Autre_entity;
import entities.Option;
import interfaces.IAutre;

/**
 * Servlet implementation class Autre_Servlet
 */
@WebServlet("/Autre_Servlet")
public class Autre_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IAutre interAutre;

	public Autre_Servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Autre_entity> vehicules = interAutre.listerAutresVehicules();

		request.setAttribute("vehicules", vehicules);
		request.getRequestDispatcher("Get_content.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String marque = String.valueOf(request.getParameter("marque"));
		String modele = String.valueOf(request.getParameter("modele"));
		String prix = String.valueOf(request.getParameter("prix"));
		Integer quantite = Integer.valueOf(request.getParameter("quantite"));
		String couleur = String.valueOf(request.getParameter("couleur"));
		String description = String.valueOf(request.getParameter("description"));

		String[] options = request.getParameterValues("options");

		List<Option> listOptions = new ArrayList<>(); 
		for(int i = 0; i< options.length; i++) {
			Option o = new Option();
			o.setName(options[i]);
			listOptions.add(o);
		}

		Autre_entity autre = new Autre_entity();
		autre.setDescription(description);
		autre.setCouleur(couleur);
		autre.setMarque(marque);
		autre.setModele(modele);
		autre.setPrix(prix);
		autre.setQuantite(quantite);
		autre.setOptions(listOptions);

		interAutre.addAutreVehicule(autre);

		request.setAttribute("vehicule", autre);

		request.getRequestDispatcher("Added_page.jsp").forward(request, response);
	}

}
