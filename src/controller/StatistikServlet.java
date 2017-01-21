package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StatistikServlet")
public class StatistikServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StatistikController sc = new StatistikController();

    public StatistikServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.getRequestDispatcher("/WEB-INF/classes/view/Statistik.jsp").include(request, response);
		response.setContentType("text/html");
		
		
		//System.out.println("TEST" + sc.gesamtPreis());

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		Date date_1 = null,date_2=null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			 date_1 = format.parse(date1);
			 date_2 = format.parse(date2);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// java code liste /// varibale
		
		double x = sc.avgPreis(date_1,date_2);
		//sm.ergktrjehl()
		
		
		request.setAttribute("minPassagier", x);
		//doGet(request, response);
		
		request.getRequestDispatcher("/WEB-INF/classes/view/Statistik.jsp").include(request, response);
		response.setContentType("text/html");
	}

}
