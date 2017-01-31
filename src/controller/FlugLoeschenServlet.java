package controller;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.buchung.dao.BuchungDAO;
import model.buchung.dao.SerializedBuchungDAO;
import model.flug.Flug;
import model.flug.dao.FlugDAO;
import model.flug.dao.SerializedFlugDAO;
import model.*;

public class FlugLoeschenServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/Skywings/management");
		response.setContentType("text/html");
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();

		// initialize FlugDAO
		String dataName = context.getInitParameter("flugpath");
		FlugDAO flugDAO = new SerializedFlugDAO(dataName);

		// initialize BuchungDAO
		String buchungDataName = context.getInitParameter("buchungpath");
		BuchungDAO buchungDAO = new SerializedBuchungDAO(buchungDataName);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd@HH:mm");

		String flugcode = request.getParameter("sel-flug");
		String[] selectedFlug = flugcode.split("#");
		String flugnr = selectedFlug[0];
		Date abflugsdatum = new Date();
		try {
			abflugsdatum = df.parse(selectedFlug[1]);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}

		flugDAO.loescheFlug(flugnr, abflugsdatum);
		buchungDAO.loescheBuchungVonFlug(flugcode);


		response.sendRedirect("/Skywings/management");
		response.setContentType("text/html");
	}
}