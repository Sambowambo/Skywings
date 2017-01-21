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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		HttpSession ss = request.getSession();

		String flugDataName = context.getInitParameter("flugpath");
		FlugDAO flugDAO = new SerializedFlugDAO(flugDataName);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd@HH:mm");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DecimalFormat decf = new DecimalFormat("0.00");
		
		String sabflug = (String)ss.getAttribute("sabflug");
		String sankunft = (String)ss.getAttribute("sankunft");
		String sdatum = (String)ss.getAttribute("sdatum");
		
		ArrayList<String> sflugnrList = new ArrayList<>();
		ArrayList<String> spreisList = new ArrayList<>();
		ArrayList<Integer> sfreiplatzList = new ArrayList<>();
		ArrayList<String> sabDatList = new ArrayList<>();
		ArrayList<String> sanDatList = new ArrayList<>();
		ArrayList<String> sabOrtList = new ArrayList<>();
		ArrayList<String> sanOrtList = new ArrayList<>();
		ArrayList<Flug> flugList=flugDAO.getFlugList();
		
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
		
		/*for(Flug iter:sflugListab) {
		if(sankunft!=null){
			sflugnrListan.add(iter.getFlugnr());
			spreisListan.add(decf.format(iter.getSitzplatz().get(0).getPreis()));
			sfreiplatzListan.add(iter.anzahlFreiplatz());
			sabDatListan.add(df.format(iter.getAbflugsdatum()));
			sanDatListan.add(df.format(iter.getAnkunftsdatum()));
			sabOrtListan.add(iter.getAbflugsort().getCode());
			sanOrtListan.add(iter.getAnkunftsort().getCode());
		}
			
		else{
			sflugnrListan.add(iter.getFlugnr());
			spreisListan.add(decf.format(iter.getSitzplatz().get(0).getPreis()));
			sfreiplatzListan.add(iter.anzahlFreiplatz());
			sabDatListan.add(df.format(iter.getAbflugsdatum()));
			sanDatListan.add(df.format(iter.getAnkunftsdatum()));
			sabOrtListan.add(iter.getAbflugsort().getCode());
			sanOrtListan.add(iter.getAnkunftsort().getCode());
		}
			
	}
		*/
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

		
		ss.invalidate();
		request.getRequestDispatcher("/WEB-INF/classes/view/fluglist.jsp").include(request, response);
		response.setContentType("text/html");
	
		
	
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss = request.getSession();
		 String sabflug = request.getParameter("Abflugort");
	     String sankunft = request.getParameter("Ankunftsort");
	     String sdatum=request.getParameter("Abflugdatum");
	     
	     ss.setAttribute("sabflug", sabflug);
	     ss.setAttribute("sankunft", sankunft);
	     ss.setAttribute("sdatum", sdatum);
	     
	     
	     response.sendRedirect("suchen");
			response.setContentType("text/html");
	}
}
