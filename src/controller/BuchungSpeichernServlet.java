package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.buchung.Buchung;
import model.buchung.dao.BuchungDAO;
import model.buchung.dao.SerializedBuchungDAO;

/**
 * Servlet implementation class BuchungSpeichernServlet
 */

public class BuchungSpeichernServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
    public BuchungSpeichernServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/classes/view/buchungansehen.jsp").include(request, response);
		response.setContentType("text/html");
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ServletContext context = getServletContext();

		String buchungDataName = context.getInitParameter("buchungpath");
		BuchungDAO bdao = new SerializedBuchungDAO(buchungDataName);
		
		
		String tel = request.getParameter("HiddenTel");
		String mail = request.getParameter("HiddenMail");
		String bknr = request.getParameter("HiddenBookingnr");
		
		
		
		Buchung booking = bdao.getBuchungbyId(bknr);
		
		booking.setEmail(mail);
		booking.setTelefonnummer(tel);
		
		
		
		
		bdao.bearbeiteBuchung(booking);
		

		//request.getRequestDispatcher("/WEB-INF/classes/view/buchungansehen.jsp").forward(request, response);
		//response.setContentType("text/html");
		response.sendRedirect("buchungansehen");
	}

}
