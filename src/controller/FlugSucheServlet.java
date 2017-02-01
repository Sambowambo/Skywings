package controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.flug.Flug;
import model.flug.dao.FlugDAO;
import model.flug.dao.SerializedFlugDAO;

//import javax.servlet.*;


public class FlugSucheServlet extends HttpServlet {
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd@HH:mm");
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private DecimalFormat decf = new DecimalFormat("0.00");

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();

		String flugDataName = context.getInitParameter("flugpath");
		FlugDAO flugDAO = new SerializedFlugDAO(flugDataName);
		ArrayList<Flug> flugList = flugDAO.getFlugList();

		String abflug = request.getParameter("Abflugort");
		String ankunft = request.getParameter("Ankunftsort");
		//String hin_option = request.getParameter("hr_flug");
		String h_datum = request.getParameter("hin_datum");
		//String r_datum = request.getParameter("rueck_dadt");

		// ArrayList for Hinflug
		ArrayList<String> h_flugnrList = new ArrayList<>();
		ArrayList<String> h_preisList = new ArrayList<>();
		ArrayList<Integer> h_freiplatzList = new ArrayList<>();
		ArrayList<String> h_abDatList = new ArrayList<>();
		ArrayList<String> h_anDatList = new ArrayList<>();
		ArrayList<String> h_abOrtList = new ArrayList<>();
		ArrayList<String> h_anOrtList = new ArrayList<>();

		// ArrayList for Rueckflug
		/*ArrayList<String> r_flugnrList = new ArrayList<>();
		ArrayList<String> r_preisList = new ArrayList<>();
		ArrayList<Integer> r_freiplatzList = new ArrayList<>();
		ArrayList<String> r_abDatList = new ArrayList<>();
		ArrayList<String> r_anDatList = new ArrayList<>();
		ArrayList<String> r_abOrtList = new ArrayList<>();
		ArrayList<String> r_anOrtList = new ArrayList<>();*/

		// Hin-List operations
		ArrayList<Flug> h_flugList = searchFlug(abflug, ankunft, h_datum, flugList);
		for(Flug iter:h_flugList) {
			h_flugnrList.add(iter.getFlugnr());
			h_preisList.add(decf.format(iter.getSitzplatz().get(0).getPreis()));
			h_freiplatzList.add(iter.anzahlFreiplatz());
			h_abDatList.add(df.format(iter.getAbflugsdatum()));
			h_anDatList.add(df.format(iter.getAnkunftsdatum()));
			h_abOrtList.add(iter.getAbflugsort().getCode());
			h_anOrtList.add(iter.getAnkunftsort().getCode());
		}

		// Rueck-List operations
		/*ArrayList<Flug> r_flugList = null;
		if (hin_option.equals("H")) {
			r_flugList = searchFlug(ankunft, abflug, r_datum, flugList);
			for(Flug iter:r_flugList) {
				r_flugnrList.add(iter.getFlugnr());
				r_preisList.add(decf.format(iter.getSitzplatz().get(0).getPreis()));
				r_freiplatzList.add(iter.anzahlFreiplatz());
				r_abDatList.add(df.format(iter.getAbflugsdatum()));
				r_anDatList.add(df.format(iter.getAnkunftsdatum()));
				r_abOrtList.add(iter.getAbflugsort().getCode());
				r_anOrtList.add(iter.getAnkunftsort().getCode());
			}
		}*/

		request.setAttribute("h_flugnrList", h_flugnrList);
		request.setAttribute("h_preisList", h_preisList);
		request.setAttribute("h_freiplatzList", h_freiplatzList);
		request.setAttribute("h_abDatList", h_abDatList);
		request.setAttribute("h_anDatList", h_anDatList);
		request.setAttribute("h_abOrtList", h_abOrtList);
		request.setAttribute("h_anOrtList", h_anOrtList);

		/*request.setAttribute("r_flugnrList", r_flugnrList);
		request.setAttribute("r_preisList", r_preisList);
		request.setAttribute("r_freiplatzList", r_freiplatzList);
		request.setAttribute("r_abDatList", r_abDatList);
		request.setAttribute("r_anDatList", r_anDatList);
		request.setAttribute("r_abOrtList", r_abOrtList);
		request.setAttribute("r_anOrtList", r_anOrtList);*/

		/*
		String sabflug = request.getParameter("Abflugort");
		String sankunft = request.getParameter("Ankunftsort");
		String sdatum = request.getParameter("Abflugdatum");

		
		ArrayList<String> sflugnrList = new ArrayList<>();
		ArrayList<String> spreisList = new ArrayList<>();
		ArrayList<Integer> sfreiplatzList = new ArrayList<>();
		ArrayList<String> sabDatList = new ArrayList<>();
		ArrayList<String> sanDatList = new ArrayList<>();
		ArrayList<String> sabOrtList = new ArrayList<>();
		ArrayList<String> sanOrtList = new ArrayList<>();
		
		ArrayList<Flug> sflugListab= new ArrayList<>();
		ArrayList<Flug> sflugListan=new ArrayList<>();
		ArrayList<Flug> sflugListdat=new ArrayList<>();
		
		

		for(Flug iter:flugList) {
		 if(!sabflug.isEmpty()){
			 
			 if(iter.getAbflugsort().getCode().equals(sabflug)){
				 sflugListab.add(iter);
			 }
		 }
					
		 else{
			sflugListab.add(iter);
		 }
		}
		
		
		for(Flug iter:sflugListab) {
			 
			if(!sankunft.isEmpty()){
				 
				if(iter.getAnkunftsort().getCode().equals(sankunft)){
					sflugListan.add(iter);
				}
			}
						
			else{
				sflugListan.add(iter);
			}
		}
		
		for(Flug iter:sflugListan) {
			 
			 if(!sdatum.isEmpty()){
				 String date_string = sdf.format(iter.getAbflugsdatum());
				 if(date_string.equals(sdatum)){
				 //if(iter.getAbflugsort().getCode().equals(sdatum)){
					 sflugListdat.add(iter);
				 }
			 }
						
			 else{
				sflugListdat.add(iter);
				 
			 }
		}

		for(Flug iter:sflugListdat) {
			sflugnrList.add(iter.getFlugnr());
			spreisList.add(decf.format(iter.getSitzplatz().get(0).getPreis()));
			sfreiplatzList.add(iter.anzahlFreiplatz());
			sabDatList.add(df.format(iter.getAbflugsdatum()));
			sanDatList.add(df.format(iter.getAnkunftsdatum()));
			sabOrtList.add(iter.getAbflugsort().getCode());
			sanOrtList.add(iter.getAnkunftsort().getCode());
		}
			


		
		request.setAttribute("test", sabflug);

		request.setAttribute("flugnrList", sflugnrList);
		request.setAttribute("preisList", spreisList);
		request.setAttribute("freiplatzList", sfreiplatzList);
		request.setAttribute("abDatList", sabDatList);
		request.setAttribute("anDatList", sanDatList);
		request.setAttribute("abOrtList", sabOrtList);
		request.setAttribute("anOrtList", sanOrtList);
		*/

		request.getRequestDispatcher("/WEB-INF/classes/view/fluglist.jsp").include(request, response);
		response.setContentType("text/html");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("suchen");
		response.setContentType("text/html");
	}

	private ArrayList<Flug> searchFlug(String abflugort, String ankunftsort, String datum, ArrayList<Flug> fromList) {
		ArrayList<Flug> searchList = new ArrayList<>();

		for(Flug iter:fromList) {
			if(iter.getAbflugsort().getCode().equals(abflugort)
					&& iter.getAnkunftsort().getCode().equals(ankunftsort)
					&& sdf.format(iter.getAbflugsdatum()).equals(datum)) {
				searchList.add(iter);
			}
		}

		return searchList;
	}
}
