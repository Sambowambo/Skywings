package controller;


import java.lang.reflect.Array;
import java.util.ArrayList;
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
	int morgen=0;
	int vormittag=0;
	int mittag=0;
	int nachmittag=0;
	int abend=0;
	int nacht=0;
	
	String zeit;
	
	for (int i=0; i<gesamtzahlFluegen(); i++){
   
		switch(flugdao.getFlugbyNummer(buchungdao.getBuchungList().get(i).getFlugcode()).getAbflugsdatum().getHours()){
		case 6: case 7: case 8: case 9: case 10: 
			morgen++;
			break;
		case 11: case 12: 
			vormittag++;
			break;
		case 13:
			mittag++;
			break;
		case 14: case 15: case 16: case 17:
			nachmittag++;
			break;
		case 18: case 19: case 20: case 21: case 22: case 23: case 0:
			abend++;
			break;
		case 1: case 2: case 3: case 4: case 5:
			nacht++;
			break;
			//default:; 
			}
	}
	
	
	return zeit;
	
	
	
	
	
}

public SortZeit(int a, int b, int c, int d, int e,int f)
{
	
	int []max = new int [6]; 
	for(int i =0;i<6;i++)
	{
		max[i]=
	}
	
}

	
}
