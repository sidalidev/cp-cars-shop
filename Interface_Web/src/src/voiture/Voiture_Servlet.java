package src.voiture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Option;
import entities.Voiture_entity;
import interfaces.IVoiture;

@WebServlet("/Voiture_Servlet")
public class Voiture_Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@EJB
	private IVoiture inter;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Voiture_Servlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Voiture_entity> voitures = inter.getVoitures();

		request.setAttribute("vehicules", voitures);
		request.getRequestDispatcher("Get_content.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String marque = String.valueOf(request.getParameter("marque"));
		String modele = String.valueOf(request.getParameter("modele"));
		String prix = String.valueOf(request.getParameter("prix"));
		String description = String.valueOf(request.getParameter("description"));
		int quantite = Integer.valueOf(request.getParameter("quantite"));
		String[] options = request.getParameterValues("options");
		String couleur = String.valueOf(request.getParameter("couleur"));

		List<Option> listOptions = new ArrayList<>(); 
		for(int i = 0; i< options.length; i++) {
			Option o = new Option();
			o.setName(options[i]);
			listOptions.add(o);
		}


		Voiture_entity voiture = new Voiture_entity();
		voiture.setMarque(marque);
		voiture.setModele(modele);
		voiture.setPrix(prix);
		voiture.setDescription(description);
		voiture.setOptions(listOptions);
		voiture.setQuantite(quantite);
		voiture.setCouleur(couleur);

		try{
			inter.addVoiture(voiture);
			String message = "Votre voiture a bien �t� ajout�e en base de donn�es.";
			request.setAttribute("message", message);
		}catch(Exception e) {
			String error = "Erreur lors de l'insertion de la voiture dans la BDD. " + e;
			request.setAttribute("error", error);
		}

		request.getRequestDispatcher("Added_page.jsp").forward(request, response);
	}

}
