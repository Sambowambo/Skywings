package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
		String tnr = "";
		tnr = request.getParameter("tnr");
		
		String buchungnr = tnr.substring(0,tnr.length()-3);
		int indexofticket = Integer.parseInt(tnr.substring(tnr.length()-3,tnr.length()))-1;
		try {
			//int indexofticket = Integer.parseInt(tnr.substring(tnr.length()-3,tnr.length()));
			
			if(tnr.equals(bdao.getBuchungbyId(buchungnr).getTicket().get(indexofticket).getTicketnummer()))
			{					
				request.setAttribute("tnr", tnr);
			}
		}
		catch (NumberFormatException|NullPointerException e) {
			request.setAttribute("tnr", "Ticket nicht gefunden bitte kontrollieren Sie ihre Eingabe!"+System.getProperty("user.dir"));
		}
		
		request.getRequestDispatcher("/WEB-INF/classes/view/buchungansehen.jsp").include(request, response);
		response.setContentType("text/html");
	}

}
