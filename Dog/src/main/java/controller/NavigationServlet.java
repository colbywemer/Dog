package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dog;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String act = request.getParameter("doThisToItem");
		String path = "/viewAllDogsServlet";
		ListItemHelper dao = new ListItemHelper();
		if(act.equals("delete")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			dog dogToDelete = dao.searchForItemById(tempId);
			dao.deleteItem(dogToDelete);
			}
			catch(NumberFormatException e) {
				System.out.println("Forgot to select a dog");
			}
		}
		else if(act.equals("edit")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			dog dogToEdit = dao.searchForItemById(tempId);
			request.setAttribute("dogToEdit", dogToEdit);
			path = "/edit-dog.jsp";
			}
			catch(NumberFormatException e) {
				System.out.println("Forgot to select a dog");
			}
		}
		else if(act.equals("add")) {
		path = "/home.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
