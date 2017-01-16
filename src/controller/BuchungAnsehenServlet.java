package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.buchung.dao.BuchungDAO;
import model.buchung.dao.SerializedBuchungDAO;

/**
 * Servlet implementation class BuchungAnsehen
 */
@WebServlet("/BuchungAnsehen")
public class BuchungAnsehenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuchungAnsehenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/classes/view/buchungansehen.jsp").include(request, response);
		response.setContentType("text/html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String buchungDataName = "../webapps/skywings/WEB-INF/save/savebuchung";
		BuchungDAO bdao = new SerializedBuchungDAO(buchungDataName);
		
		String bnr = "";
		bnr = request.getParameter("bnr");
		
		//int indexofticket = Integer.parseInt(bnr.substring(bnr.length(),bnr.length()));
		try {
			//int indexofticket = Integer.parseInt(tnr.substring(tnr.length()-3,tnr.length()));
			
			if(bnr.equals(bdao.getBuchungbyId(bnr).getBuchungid()))
			{					
				request.setAttribute("buchung", bdao.getBuchungbyId(bnr));
			}
			
			//String a = ""+bdao.getBuchungbyMail("fldsjfklfdjaa").getBuchungid();
			//request.setAttribute("tnr", a);
			
		}
		catch (NumberFormatException|NullPointerException e) {
			
			//String a = ""+bdao.getBuchungbyMail("fldsjfklfdjaa").getBuchungid();
			request.setAttribute("bnr","Buchungsnummer existiert nicht bitte erneut eingeben!");
		}
		
		request.setAttribute("bbr", true);
		if(request.getParameter("b_bearbeiten") != null) {
			request.setAttribute("bbr", false);
		}
		
		request.getRequestDispatcher("/WEB-INF/classes/view/buchungansehen.jsp").forward(request, response);
		response.setContentType("text/html");
	}

}
