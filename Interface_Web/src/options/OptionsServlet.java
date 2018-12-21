package options;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entities.OptionsEntity;
import interfaces.IOption;

/**
 * Servlet implementation class User_Servlet
 */
@WebServlet("/Options_Servlet")
public class OptionsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IOption interOption;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OptionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	List<OptionsEntity> option = interOption.getOption();
    	System.out.print("prout");
    	request.setAttribute("option", option);
    	request.getRequestDispatcher("view-option.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	
        String name = String.valueOf(request.getParameter("name"));
        System.out.print(name);
        OptionsEntity option = new OptionsEntity();
        option.setName(name);

        interOption.addOption(option);
        request.setAttribute("option", option);
        request.getRequestDispatcher("addOptions.jsp").forward(request, response);
    }

}
