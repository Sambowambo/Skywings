package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StatistikServlet")
public class StatistikServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StatistikServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.getRequestDispatcher("/WEB-INF/classes/view/Statistik.jsp").include(request, 
		response);
		response.setContentType("text/html");
		
		
		//System.out.println("TEST" + sc.gesamtPreis());

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String buchungDataName = context.getInitParameter("buchungpath");
		String flugDataName = context.getInitParameter("flugpath");
		StatistikController sc = new StatistikController(buchungDataName, flugDataName);
	
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		
		String g4 = request.getParameter("checkboxG4");
		String g5 = request.getParameter("checkboxG5");
		String g6 = request.getParameter("checkboxG6");
		String g7 = request.getParameter("checkboxG7");
		String g8 = request.getParameter("checkboxG8");
		String g9 = request.getParameter("checkboxG9");
		String g10 = request.getParameter("checkboxG10");
		String g11 = request.getParameter("checkboxG11");
		String g12 = request.getParameter("checkboxG12");
		String g13 = request.getParameter("checkboxG13");
		String g14 = request.getParameter("checkboxG14");
		String g15 = request.getParameter("checkboxG15");
		
		Date date_1 = null,date_2=null;
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			 date_1 = format.parse(date1);
			 date_2 = format.parse(date2);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(g13 != null) {
			double avgPreis = sc.avgPreis(date_1,date_2);
			request.setAttribute("avgPreis", avgPreis);
		}
		
		if(g4 != null) {
			int gesamtFlug = sc.gesamtzahlFluegen();
			request.setAttribute("gesamtFlug", gesamtFlug);
		}
		
		if(g5 != null) {
			int gesamtBuch = sc.gesamtzahlBuchungen();
			request.setAttribute("gesamtBuch", gesamtBuch);
		}
		
		if(g6 != null) {
			double durchPreis = sc.durchschnittPreis();
			request.setAttribute("durchPreis", durchPreis);
		}
		
		if(g7 != null) {
			int gesamPass= sc.gesamtzahlPassagieren();
			request.setAttribute("gesamPass", gesamPass);
		}
		
		if(g8 != null) {
			int minPass = sc.minPassagieren(date_1, date_2);
			request.setAttribute("minPass", minPass);
		}
		
		if(g9 != null) {
			int maxPass = sc.maxPassagieren(date_1,date_2);
			request.setAttribute("maxPass", maxPass);
		}
		
		if(g10 != null) {
			double avgPass = sc.avgPassagieren(date_1,date_2);
			request.setAttribute("avgPass", avgPass);
		}
		
		if(g11 != null) {
			double minPreis = sc.minPreis(date_1,date_2);
			request.setAttribute("minPreis", minPreis);
		}
		
		if(g12 != null) {
			double maxPreis = sc.maxPreis(date_1,date_2);
			request.setAttribute("maxPreis", maxPreis);
		}
		
		if(g14 != null) {
			double gesamtPreis = sc.gesamtPreis();
			request.setAttribute("gesamtPreis", gesamtPreis);
		}
		
		if(g15 != null) {
			String zeit = sc.Zeitintensitaet();
			request.setAttribute("zeit", zeit);
		}
		
		request.setAttribute("date1", date1);
		request.setAttribute("date2", date2);
		//doGet(request, response);
		
		request.getRequestDispatcher("/WEB-INF/classes/view/Statistik.jsp").include(request, 
		response);
		response.setContentType("text/html");
	}

}
