package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import model.*;
import model.flug.*;
import model.flug.dao.*;

public class FlugController  {
 
	FlugDAO flugDAO;
	
	
	public FlugController(String pfad){
		flugDAO = new SerializedFlugDAO(pfad);
	}
	
	public FlugDAO getFlugDAO(){
		
		return flugDAO;
		
	}
	
	public void setFlugDAO(FlugDAO flugDAO){
		this.flugDAO=flugDAO;
		
	}
	
		
	/*public boolean flugEintragen(int flugid, String flugnummer, double preis, Date abDatum, Date anDatum, Flughafen abflugsort, Flughafen ankunftsort) throws IOException{
		Flug neuflug= new Flug (flugid, flugnummer, preis, abflugsort, ankunftsort, abDatum, anDatum);
		return flugDAO.speichereFlug(neuflug);
	}*/
	
	/*public boolean flugAendern(int flugid, Date neuabDatum, Date neuanDatum) throws IOException{
		flugDAO.getFlugbyId(flugid).setAbflugsdatum(neuabDatum);

		flugDAO.getFlugbyId(flugid).setAnkunftsdatum(neuanDatum);
		return true;
					
	}*/
	
	/*public boolean flugLoeschen(int flugid){
		return flugDAO.loescheFlug(flugDAO.getFlugbyId(flugid));
	}
	
	//klassendiagramm ?ndern
	public Flug flugSuche(int flugid){
		return flugDAO.getFlugbyId(flugid);
	}*/

	// flugSuche overloading: return ArrayList<flug> for searching via time and place
	/*public ArrayList<Flug> flugSuche(Flughafen abflugsort, Flughafen ankunftsort, Date abDatum) {
		ArrayList<Flug> suchlist = new ArrayList<>();
		ArrayList<Flug> flugList = flugDAO.getFlugbyDatum(abDatum);

		for(Flug iter:flugList)
			if(iter.getAbflugsort == abflugsort && iter.getAnkunftsort == ankunftsort)
				suchlist.add(iter);

		return suchlist;
	}*/
}


