package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dog;

/**
 * Servlet implementation class EditDogServlet
 */
@WebServlet("/editDogServlet")
public class EditDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		ListItemHelper dao = new ListItemHelper();
		String name = request.getParameter("name");
		String breed = request.getParameter("breed");
		String color = request.getParameter("color");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		dog dogToEdit = dao.searchForItemById(tempId);
		dogToEdit.setName(name);
		dogToEdit.setBreed(breed);
		dogToEdit.setColor(color);
		dao.updateItem(dogToEdit);
		getServletContext().getRequestDispatcher("/viewAllDogsServlet").forward(request, response);
	}

}
