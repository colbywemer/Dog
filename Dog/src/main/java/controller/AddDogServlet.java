package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dog;

/**
 * Servlet implementation class AddDogServlet
 */
@WebServlet("/addDogServlet")
public class AddDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String breed = request.getParameter("breed");
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		dog dog = new dog(breed, name, color);
		ListItemHelper dao = new ListItemHelper();
		dao.insetItem(dog);
		getServletContext().getRequestDispatcher("/home.html").forward(request, response);
	}

}
