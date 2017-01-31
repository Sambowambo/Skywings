package model.buchung.dao;

import java.util.ArrayList;
import java.util.Date;

import model.buchung.Buchung;

public interface BuchungDAO {
	 public ArrayList<Buchung> getBuchungList();
	 public Buchung getBuchungbyId(String buchingid);
	 public boolean speichereBuchung(Buchung buchung);
	 public boolean loescheBuchung(Buchung buchung);
	 public boolean loescheBuchungVonFlug(String flugcode);
	 //test getBuchungbyMail
	 public Buchung getBuchungbyMail(String mail);
	 public boolean bearbeiteBuchung(Buchung buchung);
}
