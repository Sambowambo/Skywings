package controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import model.buchung.dao.BuchungDAO;
import model.buchung.dao.SerializedBuchungDAO;

import model.flug.dao.FlugDAO;
import model.flug.dao.SerializedFlugDAO;

public class StatistikController {

	private String buchungDataName = "../webapps/skywings/WEB-INF/save/savebuchung";
	private String flugDataName = "../webapps/skywings/WEB-INF/save/saveflug";
	private BuchungDAO buchungdao; 
	private FlugDAO flugdao;
	private int sitzplatz=200;
	
	
	public StatistikController() {
		
		this.buchungdao = new SerializedBuchungDAO(buchungDataName);
		this.flugdao = new SerializedFlugDAO(flugDataName);
	}
	//v
	public int gesamtzahlFluegen(){
		return this.flugdao.getFlugList().size();
	}

	//v
	public int gesamtzahlBuchungen(){
		return this.buchungdao.getBuchungList().size(); }
		
		//v
		public double durchschnittPreis (){
		
			double sum= 0 ;
			int frei;
			double preis;
			int sumsitz=0;
		
			for(int i = 0 ; i <gesamtzahlFluegen(); i++){
				
				String[] flugcode = buchungdao.getBuchungList().get(i).getFlugcode().split("#"); // ab123#2016-05-06@12:34
				String flugnummer = flugcode[0];
				
			 frei = flugdao.getFlugbyNummer(flugnummer).anzahlFreiplatz();
			 
			 preis = flugdao.getFlugbyNummer(flugnummer).getSitzplatz().get(i).getPreis();
				
			  		sumsitz+=(sitzplatz-frei);
					sum+= (sitzplatz-frei)*preis; 
			}
			return sum/sumsitz;
			
			
			}
   
		
		//v
		public double gesamtPreis(){
			double sum= 0 ;
			int frei;
			double preis;
			
		
			for(int i = 0 ; i <gesamtzahlFluegen(); i++){
				String[] flugcode = buchungdao.getBuchungList().get(i).getFlugcode().split("#"); // ab123#2016-05-06@12:34
				String flugnummer = flugcode[0];
			 frei = flugdao.getFlugbyNummer(flugnummer).anzahlFreiplatz();
				
			  preis = flugdao.getFlugbyNummer(flugnummer).getSitzplatz().get(i).getPreis();
				
			  		
					sum+= (sitzplatz-frei)*preis;
			}
			return sum;
		}
		//v
		public int gesamtzahlPassagieren(){
	
			int frei;
	
			int sumpas=0;
			
			for(int i = 0 ; i <gesamtzahlFluegen(); i++){
				String[] flugcode = buchungdao.getBuchungList().get(i).getFlugcode().split("#"); // ab123#2016-05-06@12:34
				String flugnummer = flugcode[0];
				 frei = flugdao.getFlugbyNummer(flugnummer).anzahlFreiplatz();
			
				  		sumpas+=(sitzplatz-frei);
				
				}
		
			return sumpas;		}
		
		
		//v
		public int minPassagieren(Date date1, Date date2){
		
		
			ArrayList <Integer> passag = new ArrayList<Integer>();
			for(int i = 0 ; i <gesamtzahlFluegen(); i++){
				String[] flugcode = buchungdao.getBuchungList().get(i).getFlugcode().split("#"); // ab123#2016-05-06@12:34
				String abflugsdatum = flugcode[1];
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd@HH:mm");
				Date ab_datum;
				try {
					ab_datum = sdf.parse(abflugsdatum);
				}
				catch (ParseException e) {
					e.printStackTrace();
					return -1;
				}
				
				if (date1.before(ab_datum) && date2.after(ab_datum)) {
					passag.add(sitzplatz-flugdao.getFlugbyNrandDatum(flugcode[0], ab_datum).anzahlFreiplatz());
				}
			}
			
			if(passag.size() == 0) return 0;
			else {
				int min=passag.get(0);
				
				for (int i=1; i<passag.size(); i++){
					if(passag.get(i)>min);
					else min=passag.get(i);
				}
				return min;
			}
			
		}
		
		//v
		public int maxPassagieren(Date date1, Date date2){
			
			
			ArrayList <Integer> passag = new ArrayList<Integer>();
			for(int i = 0 ; i <gesamtzahlFluegen(); i++){
				String[] flugcode = buchungdao.getBuchungList().get(i).getFlugcode().split("#"); // ab123#2016-05-06@12:34
				String abflugsdatum = flugcode[1];
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd@HH:mm");
				Date ab_datum;
				try {
					ab_datum = sdf.parse(abflugsdatum);
				}
				catch (ParseException e) {
					e.printStackTrace();
					return -1;
				}
				if (date1.before(ab_datum) && date2.after(ab_datum)) {
					passag.add(sitzplatz-flugdao.getFlugbyNrandDatum(flugcode[0], ab_datum).anzahlFreiplatz());
				}
			}
			
			if(passag.size() == 0) return 0;
			else {
			int max=passag.get(0);
			
			for (int i=1; i<passag.size(); i++){
				if(passag.get(i)<max);
				else max=passag.get(i);
			}
			return max;
			}
			
		}
		
		//v
	public int avgPassagieren(Date date1, Date date2){
		
			
			int sum=0;
			int g=0;
			
			for(int i = 0 ; i <gesamtzahlFluegen(); i++){
				String[] flugcode = buchungdao.getBuchungList().get(i).getFlugcode().split("#"); // ab123#2016-05-06@12:34
				String abflugsdatum = flugcode[1];
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd@HH:mm");
				Date ab_datum;
				try {
					ab_datum = sdf.parse(abflugsdatum);
				}
				catch (ParseException e) {
					e.printStackTrace();
					return -1;
				}
				if (date1.before(ab_datum) && date2.after(ab_datum)) {
				  sum+=sitzplatz-flugdao.getFlugbyNrandDatum(flugcode[0], ab_datum).anzahlFreiplatz();
				  g++;
				}
			}
			return sum/g;
					
		}
		
	

	
	//v
	public double minPreis(Date date1, Date date2){

		double preis;
		
		ArrayList <Double> passag = new ArrayList<Double>();
		for(int i = 0 ; i <gesamtzahlFluegen(); i++){
			String[] flugcode = buchungdao.getBuchungList().get(i).getFlugcode().split("#"); // ab123#2016-05-06@12:34
			String abflugsdatum = flugcode[1];
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd@HH:mm");
			Date ab_datum;
			try {
				ab_datum = sdf.parse(abflugsdatum);
			}
			catch (ParseException e) {
				e.printStackTrace();
				return -1;
			}
			if (date1.before(ab_datum) && 
					date2.after(ab_datum)) {
				preis = flugdao.getFlugbyNrandDatum(flugcode[0], ab_datum).getSitzplatz().get(i).getPreis();
				passag.add((sitzplatz-flugdao.getFlugbyNrandDatum(flugcode[0], ab_datum).anzahlFreiplatz())*preis);
			}
		}
		
		if(passag.size() == 0) return 0;
		else {
		double min=passag.get(0);
		
		for (int i=1; i<passag.size(); i++){
			if(passag.get(i)>min);
			else min=passag.get(i);
		}
		return min;
		}
		
	}
	
	//v
	
	public double maxPreis(Date date1, Date date2){

		double preis;
		
		ArrayList <Double> passag = new ArrayList<Double>();
		for(int i = 0 ; i <gesamtzahlFluegen(); i++){
			String[] flugcode = buchungdao.getBuchungList().get(i).getFlugcode().split("#"); // ab123#2016-05-06@12:34
			String abflugsdatum = flugcode[1];
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd@HH:mm");
			Date ab_datum;
			try {
				ab_datum = sdf.parse(abflugsdatum);
			}
			catch (ParseException e) {
				e.printStackTrace();
				return -1;
			}
			if (date1.before(ab_datum) && 
					date2.after(ab_datum)) {
				preis = flugdao.getFlugbyNrandDatum(flugcode[0], ab_datum).getSitzplatz().get(i).getPreis();
				passag.add((sitzplatz-flugdao.getFlugbyNrandDatum(flugcode[0], ab_datum).anzahlFreiplatz())*preis);
			}
		}
		
		if(passag.size() == 0) return 0;
		else {
		double max=passag.get(0);
		
		for (int i=1; i<passag.size(); i++){
			if(passag.get(i)<max);
			else max=passag.get(i);
		}
		return max;
					
		}
	}
	
	
	//v
public double avgPreis(Date date1, Date date2){
	
		
		int sum=0;
		int g=0;
		double preis;
		
		for(int i = 0 ; i <gesamtzahlFluegen(); i++){
			String[] flugcode = buchungdao.getBuchungList().get(i).getFlugcode().split("#"); // ab123#2016-05-06@12:34
			String abflugsdatum = flugcode[1];
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd@HH:mm");
			Date ab_datum;
			try {
				ab_datum = sdf.parse(abflugsdatum);
			}
			catch (ParseException e) {
				e.printStackTrace();
				return -1;
			}
			if (date1.before(ab_datum) && date2.after(ab_datum)) {
				preis = flugdao.getFlugbyNrandDatum(flugcode[0], ab_datum).getSitzplatz().get(i).getPreis();
				sum+=(sitzplatz-flugdao.getFlugbyNrandDatum(flugcode[0], ab_datum).anzahlFreiplatz())*preis;
			  g++;
			}
		}
		return sum/g;
				
	}
	
@SuppressWarnings("deprecation")
public String Zeitintensitaet(){
		
	// zeiten[] beinhaltet die einzelnen zeiten in folgender reihenfolge 
	//zeiten[0]..morgen, zeiten[1]..vormittag,zeiten[2]..mittag,zeiten[3]..nachmittag,zeiten[4]..abend,zeiten[5]..nacht
	int zeiten [] = new int []{0,0,0,0,0,0};
	
	int maxintensitaet;
	String maxzeit="";
	
	for (int i=0; i<gesamtzahlFluegen(); i++){
		String[] flugcode = buchungdao.getBuchungList().get(i).getFlugcode().split("#"); // ab123#2016-05-06@12:34
		String abflugsdatum = flugcode[1];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd@HH:mm");
		Date ab_datum = null;
		try {
			ab_datum = sdf.parse(abflugsdatum);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}

		switch(ab_datum.getHours()){
		case 6: case 7: case 8: case 9: case 10: 
			zeiten[0]++;
			break;
		case 11: case 12: 
			zeiten[1]++;
			break;
		case 13:
			zeiten[2]++;
			break;
		case 14: case 15: case 16: case 17:
			zeiten[3]++;
			break;
		case 18: case 19: case 20: case 21: case 22: case 23: case 0:
			zeiten[4]++;
			break;
		case 1: case 2: case 3: case 4: case 5:
			zeiten[5]++;
			break;
			//default:; 
			}
	}
	
	maxintensitaet=SortZeit(zeiten);
	
	for(int i =0;i<zeiten.length;i++)
	{
		if(zeiten[0]==maxintensitaet)
		{
			maxzeit=maxzeit+" morgen: "+maxintensitaet;
		}
		else if(zeiten[1]==maxintensitaet)
		{
			maxzeit=maxzeit+" vormittag: "+maxintensitaet;			
		}
		else if(zeiten[2]==maxintensitaet)
		{
			maxzeit=maxzeit+" mittag: "+maxintensitaet;
		}
		else if(zeiten[3]==maxintensitaet)
		{
			maxzeit=maxzeit+" nachmittag: "+maxintensitaet;
		}
		else if(zeiten[4]==maxintensitaet)
		{
			maxzeit=maxzeit+" abend: "+maxintensitaet;
		}
		else if(zeiten[5]==maxintensitaet)
		{
			maxzeit=maxzeit+" nacht: "+maxintensitaet;
		}
	}
	
	
	return maxzeit;
	
	
	
	
	
}

public int SortZeit(int zeiten[])
{
	
	Arrays.sort(zeiten); 
	
	return zeiten[0];
}

	
}
