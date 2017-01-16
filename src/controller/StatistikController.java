package controller;


import java.lang.reflect.Array;
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
	private BuchungDAO buchungdao = new SerializedBuchungDAO(buchungDataName); 
	private FlugDAO flugdao = new SerializedFlugDAO(flugDataName);
	private int sitzplatz=200;
	
	
	public StatistikController(BuchungDAO buchungdao, FlugDAO flugdao) {
		
		this.buchungdao = buchungdao;
		this.flugdao = flugdao;
	}
	
	public int gesamtzahlFluegen(){
		return this.flugdao.getFlugList().size();
	}

	
	public int gesamtzahlBuchungen(){
		return this.buchungdao.getBuchungList().size(); }
		
		
		public double durchschnittPreis (){
		
			double sum= 0 ;
			int frei;
			double preis;
			int sumsitz=0;
		
			for(int i = 0 ; i <gesamtzahlFluegen(); i++){
			 frei = flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).anzahlFreiplatz();
				
			  preis = flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getSitzplatz().get(i).getPreis();
				
			  		sumsitz+=(sitzplatz-frei);
					sum+= (sitzplatz-frei)*preis;
			}
			return sum/sumsitz;
			
			//flugdao.getFlugbyNummer(buchungdao.getBuchungbyId("2").getFlugcode()).anzahlFreiplatz();
			}
   
		
		
		public double gesamtPreis(){
			double sum= 0 ;
			int frei;
			double preis;
			
		
			for(int i = 0 ; i <gesamtzahlFluegen(); i++){
			 frei = flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).anzahlFreiplatz();
				
			  preis = flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getSitzplatz().get(i).getPreis();
				
			  		
					sum+= (sitzplatz-frei)*preis;
			}
			return sum;
		}
		
		public int gesamtzahlPassagieren(){
	
			int frei;
	
			int sumpas=0;
			
			for(int i = 0 ; i <gesamtzahlFluegen(); i++){
				 frei = flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).anzahlFreiplatz();
			
				  		sumpas+=(sitzplatz-frei);
				
				}
		
			return sumpas;		}
		
		public int minPassagieren(Date date1, Date date2){
		
		
			ArrayList <Integer> passag = new ArrayList<Integer>();
			for(int i = 0 ; i <gesamtzahlFluegen(); i++){
				if (date1.after(flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getAbflugsdatum()) && date2.before(flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getAbflugsdatum())) {
					passag.add(sitzplatz-flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).anzahlFreiplatz());
				}
			}
			int min=passag.get(0);
			
			for (int i=1; i<passag.size(); i++){
				if(passag.get(i)>min);
				else min=passag.get(i);
			}
			return min;
						
			
		}
		
		
		public int maxPassagieren(Date date1, Date date2){
			
			
			ArrayList <Integer> passag = new ArrayList<Integer>();
			for(int i = 0 ; i <gesamtzahlFluegen(); i++){
				if (date1.after(flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getAbflugsdatum()) && date2.before(flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getAbflugsdatum())) {
					passag.add(sitzplatz-flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).anzahlFreiplatz());
				}
			}
			int max=passag.get(0);
			
			for (int i=1; i<passag.size(); i++){
				if(passag.get(i)<max);
				else max=passag.get(i);
			}
			return max;
						
			
		}
		
	public int avgPassagieren(Date date1, Date date2){
		
			
			int sum=0;
			int g=0;
			
			for(int i = 0 ; i <gesamtzahlFluegen(); i++){
				if (date1.after(flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getAbflugsdatum()) && date2.before(flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getAbflugsdatum())) {
				  sum+=sitzplatz-flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).anzahlFreiplatz();
				  g++;
				}
			}
			return sum/g;
					
		}
		
	

	
	
	public double minPreis(Date date1, Date date2){

		double preis;
		
		ArrayList <Double> passag = new ArrayList<Double>();
		for(int i = 0 ; i <gesamtzahlFluegen(); i++){
			if (date1.after(flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getAbflugsdatum()) && 
					date2.before(flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getAbflugsdatum())) {
				preis = flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getSitzplatz().get(i).getPreis();
				passag.add((sitzplatz-flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).anzahlFreiplatz())*preis);
			}
		}
		double min=passag.get(0);
		
		for (int i=1; i<passag.size(); i++){
			if(passag.get(i)>min);
			else min=passag.get(i);
		}
		return min;
					
		
	}
	
	
	public double maxPreis(Date date1, Date date2){

		double preis;
		
		ArrayList <Double> passag = new ArrayList<Double>();
		for(int i = 0 ; i <gesamtzahlFluegen(); i++){
			if (date1.after(flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getAbflugsdatum()) && 
					date2.before(flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getAbflugsdatum())) {
				preis = flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getSitzplatz().get(i).getPreis();
				passag.add((sitzplatz-flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).anzahlFreiplatz())*preis);
			}
		}
		double max=passag.get(0);
		
		for (int i=1; i<passag.size(); i++){
			if(passag.get(i)<max);
			else max=passag.get(i);
		}
		return max;
					
		
	}
	
public double avgPreis(Date date1, Date date2){
	
		
		int sum=0;
		int g=0;
		double preis;
		
		for(int i = 0 ; i <gesamtzahlFluegen(); i++){
			if (date1.after(flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getAbflugsdatum()) && date2.before(flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getAbflugsdatum())) {
				preis = flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getSitzplatz().get(i).getPreis();
				sum+=(sitzplatz-flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).anzahlFreiplatz())*preis;
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
   
		switch(flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getAbflugsdatum().getHours()){
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
