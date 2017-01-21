package controller;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.flug.Flug;
import model.flug.dao.FlugDAO;
import model.flug.dao.SerializedFlugDAO;
import model.*;

public class FlugLoeschenServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/skywings/management");
		response.setContentType("text/html");
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();

		String dataName = context.getInitParameter("flugpath");
		FlugDAO flugDAO = new SerializedFlugDAO(dataName);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd@HH:mm");

		String[] selectedFlug = request.getParameter("sel-flug").split("#");
		String flugnr = selectedFlug[0];
		Date abflugsdatum = new Date();
		try {
			abflugsdatum = df.parse(selectedFlug[1]);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}

		flugDAO.loescheFlug(flugnr, abflugsdatum);

		response.sendRedirect("/skywings/management");
		response.setContentType("text/html");
	}
}