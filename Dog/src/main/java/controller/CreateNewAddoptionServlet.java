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
 * Servlet implementation class CreateNewAddoptionServlet
 */
@WebServlet("/createNewAddoptionServlet")
public class CreateNewAddoptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewAddoptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListItemHelper lih = new ListItemHelper();
		String address = request.getParameter("address");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String ownerName = request.getParameter("ownerName");
		String phoneNumber = request.getParameter("phoneNumber");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException e) {
			ld = LocalDate.now();
		}
		String[] selectedDogs = request.getParameterValues("allItemsToAdd");
		List<dog> selectedDogsInList = new ArrayList<dog>();
		if(selectedDogs != null && selectedDogs.length > 0) {
			for(int i = 0; i <selectedDogs.length; i++) {
				System.out.println(selectedDogs[i]);
				dog c = lih.searchForItemById(Integer.parseInt(selectedDogs[i]));
				selectedDogsInList.add(c);
			}
		}
		AddoptionDetails ald = new AddoptionDetails(ownerName, address, phoneNumber, ld);
		ald.setListOfDogs(selectedDogsInList);
		AddoptionDetailsHelper alh = new AddoptionDetailsHelper();
		alh.insertNewAddoptionDetails(ald);
		getServletContext().getRequestDispatcher("/viewAllAddoptionsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
