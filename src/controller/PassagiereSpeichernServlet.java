package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.buchung.Buchung;
import model.buchung.dao.BuchungDAO;
import model.buchung.dao.SerializedBuchungDAO;


public class PassagiereSpeichernServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PassagiereSpeichernServlet() {
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
		
		
		
		String bknr = request.getParameter("HiddenBookingnr");
		
		
		
		String nameid = request.getParameter("HiddenNameId");
		String name = request.getParameter(nameid);
		
		String nachnameid = request.getParameter("HiddenNachnameId");
		String nachname = request.getParameter(nachnameid);
		
		String gebdatid = request.getParameter("HiddenGebdatId");
		String gebdat = request.getParameter(gebdatid);
		
		String passid = request.getParameter("HiddenPassnrId");
		String pass = request.getParameter(passid);
		
		String nationid = request.getParameter("HiddenNationId");
		String nation = request.getParameter(nationid);
		
		String adressid = request.getParameter("HiddenAdressId");
		String adress = request.getParameter(adressid);
		
		String plzid = request.getParameter("HiddenPlzId");
		String plz = request.getParameter(plzid);


		
		
		
		int id=0;
		
		try{
			id = Integer.parseInt(nameid.substring(nameid.length() - 1));
			id= id -1;
	    }catch(NumberFormatException e){
	        throw e;
	    }
		
		
		
		
		Buchung booking = bdao.getBuchungbyId(bknr);
		
	
		
		booking.getPassagier().get(id).setVorname(name);
		booking.getPassagier().get(id).setNachname(nachname);
		//booking.getPassagier().get(id).setGeburtsdatum(gebdat);
		booking.getPassagier().get(id).setPassnummer(pass);
		booking.getPassagier().get(id).setNationalitaet(nation);
		booking.getPassagier().get(id).setStrasse(adress);
		booking.getPassagier().get(id).setPostleitzahl(plz);
		
		bdao.bearbeiteBuchung(booking);
		

		//request.getRequestDispatcher("/WEB-INF/classes/view/buchungansehen.jsp").forward(request, response);
		//response.setContentType("text/html");
		response.sendRedirect("buchungansehen");
	}

}
