package user;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.UserEntity;
import interfaces.IUser;

@WebServlet("/Users_Servlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IUser interUser;

	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserEntity user = interUser.getUser(request.getParameter("email"));
		System.out.print(user.getPassword());
			if (user.getPassword().equals(request.getParameter("password"))) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		String email = String.valueOf(request.getParameter("email"));
		String password = String.valueOf(request.getParameter("password"));

		UserEntity user = new UserEntity();
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(2);

		interUser.addUser(user);

		HttpSession session = request.getSession(true);
		session.setAttribute("currentSessionUser", user);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
