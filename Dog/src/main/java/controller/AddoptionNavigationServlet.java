package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddoptionDetails;

/**
 * Servlet implementation class AddoptionNavigationServlet
 */
@WebServlet("/addoptionNavigationServlet")
public class AddoptionNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddoptionNavigationServlet() {
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
		AddoptionDetailsHelper dao = new AddoptionDetailsHelper();
		String act = request.getParameter("doThisToList");
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllAddoptionsServlet").forward(request, response);
		}
		else if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AddoptionDetails listToDelete = dao.searchForAddoptionDetailsById(tempId);
				dao.deleteAddoption(listToDelete);
			}catch(NumberFormatException e) {
				System.out.println("Forgot to click a button");
			}finally{
				getServletContext().getRequestDispatcher("/viewAllAddoptionsServlet").forward(request, response);
			}
		}
		else if(act.equals("edit")) {
			try {
				Integer tempInt = Integer.parseInt(request.getParameter("id"));
				AddoptionDetails addoptionToEdit = dao.searchForAddoptionDetailsById(tempInt);
				request.setAttribute("addoptionToEdit", addoptionToEdit);
				request.setAttribute("month", addoptionToEdit.getAdoptionDate().getMonthValue());
				request.setAttribute("date", addoptionToEdit.getAdoptionDate().getDayOfMonth());
				request.setAttribute("year", addoptionToEdit.getAdoptionDate().getYear());
				ListItemHelper daoForItems = new ListItemHelper();
				request.setAttribute("allItems", daoForItems.showAllItems());
				if(daoForItems.showAllItems().isEmpty()) {
					request.setAttribute("allItems", " ");
				}
				getServletContext().getRequestDispatcher("/edit-addoption.jsp").forward(request, response);
			}catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllAddoptionsServlet").forward(request, response);
			}
		}
		else if(act.equals("add")) {
			getServletContext().getRequestDispatcher("/addDogsForAddoptionServlet").forward(request, response);
		}
	}

}
