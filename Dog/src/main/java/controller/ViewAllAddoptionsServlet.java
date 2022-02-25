package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddoptionDetails;

/**
 * Servlet implementation class ViewAllAddoptionsServlet
 */
@WebServlet("/viewAllAddoptionsServlet")
public class ViewAllAddoptionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllAddoptionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddoptionDetailsHelper alh = new AddoptionDetailsHelper();
		List<AddoptionDetails> abc = alh.getAddoptions();
		request.setAttribute("allAddoptions", abc);
		String path = "/addoption-list-by-user.jsp";
		if(abc.isEmpty()){
		path = "/home.html";
		System.out.println("Empty");
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
