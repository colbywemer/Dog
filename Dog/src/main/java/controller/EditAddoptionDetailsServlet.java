package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddoptionDetails;
import model.dog;

/**
 * Servlet implementation class EditAddoptionDetailsServlet
 */
@WebServlet("/editAddoptionDetailsServlet")
public class EditAddoptionDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAddoptionDetailsServlet() {
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
		ListItemHelper lih = new ListItemHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		AddoptionDetails addoptionToUpdate = dao.searchForAddoptionDetailsById(tempId);
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String ownerName = request.getParameter("ownerName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException e) {
			ld = LocalDate.now();
		}
		try {
			String[] selectedDogs = request.getParameterValues("allItemsToAdd");
			List<dog> selectedDogsInList = new ArrayList<dog>();
			for(int i = 0; i < selectedDogs.length; i++) {
				dog c = lih.searchForItemById(Integer.parseInt(selectedDogs[i]));
				selectedDogsInList.add(c);
			}
			addoptionToUpdate.setListOfDogs(selectedDogsInList);
		}catch(NullPointerException ex) {
			List<dog> selectedDogsInList = new ArrayList<dog>();
			addoptionToUpdate.setListOfDogs(selectedDogsInList);
		}
			addoptionToUpdate.setAddress(address);
			addoptionToUpdate.setAdoptionDate(ld);
			addoptionToUpdate.setOwnerName(ownerName);
			dao.updateAddoption(addoptionToUpdate);
			getServletContext().getRequestDispatcher("/viewAllAddoptionsServlet").forward(request, response);
		
	}

}
