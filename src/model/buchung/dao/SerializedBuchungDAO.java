package model.buchung.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import model.buchung.Buchung;

public class SerializedBuchungDAO implements BuchungDAO, Serializable{
	private ArrayList <Buchung> leerlist = new ArrayList <Buchung>();
	private String dataName; 

    public SerializedBuchungDAO(String _dataName) {
        dataName = _dataName;

        if(!(new File(dataName).exists())) {
            ArrayList<Buchung> buchungList;

            try {                
                FileOutputStream fos = new FileOutputStream(dataName);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                buchungList = new ArrayList<>();
                oos.writeObject(buchungList);

                oos.close();
                fos.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Buchung> getBuchungList() {
		ArrayList<Buchung> buchungList = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(dataName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            buchungList = (ArrayList<Buchung>) ois.readObject();

            ois.close();
            fis.close();
        }
        catch(IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return buchungList;
	}

	@Override
	public Buchung getBuchungbyId(String buchingid) {
		ArrayList<Buchung> suchlist = this.getBuchungList();
		for(int i=0; i<suchlist.size(); i++) {
			if (suchlist.get(i).getBuchungid().equals(buchingid)) {
				return suchlist.get(i); 
			}
		}
	//System.out.println("Buchung mit dieser Id konnte nicht gefunden werden!");
		return null;
	}
	
	//testFUNKTION getBuchungbyCode
	
	public Buchung getBuchungbyMail(String mail){
		ArrayList<Buchung> suchlist = this.getBuchungList();
		
		for(int i=0; i<suchlist.size();i++){
			if(suchlist.get(i).getEmail().equals(mail)){
				return suchlist.get(i);
			}
		}
		return null;
	}
	
	
	//testFUNKTIOn getBuchungbyCode

	@Override
	public boolean speichereBuchung(Buchung buchung) {
		ArrayList<Buchung> buchungList = getBuchungList();
        
        for(Buchung iter:buchungList)
        	if(iter.getBuchungid().equals(buchung.getBuchungid()))
        		throw new IllegalArgumentException("Tut mir leid! Es gibt schon eine Buchung mit dieser Id!");

        buchungList.add(buchung);

        try {
            FileOutputStream fos = new FileOutputStream(dataName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(buchungList);

            oos.close();
            fos.close();

            return true;
        }
        catch(IOException e) {
            e.printStackTrace();
            return false;
        }
	}
	public boolean bearbeiteBuchung(Buchung buchung)
	{
		ArrayList<Buchung> buchungList = getBuchungList();
		String id = buchung.getBuchungid();
		
		
		for(Buchung iter:buchungList){
        	if(iter.getBuchungid().equals(id)){
        		iter.setEmail(buchung.getEmail());
        		iter.setTelefonnummer(buchung.getTelefonnummer());
        		iter.setPassagier(buchung.getPassagier());
        		
        		
        	}
        	
		}
        		//throw new IllegalArgumentException("Tut mir leid! Es gibt schon eine Buchung mit dieser Id!");

		try {
            FileOutputStream fos = new FileOutputStream(dataName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(buchungList);

            oos.close();
            fos.close();

            return true;
        }
        catch(IOException e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean loescheBuchung(Buchung buchung) {
		if (buchung != null) {
            ArrayList<Buchung> speicherliste = this.getBuchungList();
            for (Buchung buchung2 : speicherliste) {
                if (buchung.getBuchungid() == buchung2.getBuchungid()) {
                    buchung = buchung2;
                    break;
                }
            }

            while (speicherliste.contains(buchung)) {
                speicherliste.remove(buchung);
            }

            try {
                FileOutputStream fileos = new FileOutputStream(dataName);
                ObjectOutputStream obos = new ObjectOutputStream(fileos);
                obos.writeObject(speicherliste);
                fileos.close();
                obos.close();
                //System.out.println("Geloescht");
    
            } catch (IOException e) {
            	//System.out.println("Problem mit Output!");
                e.printStackTrace();
                return false;
            }
        } else throw new IllegalArgumentException("Tut mir leid! Es gibt keine Buchung mit dieser Id!");
       	return true;
	}

	@Override
    public boolean loescheBuchungVonFlug(String flugcode) {
	    ArrayList<Buchung> buchungList = getBuchungList();

	    for(int i=0; i<buchungList.size(); i++) {
            if(buchungList.get(i).getFlugcode().equals(flugcode))
                buchungList.remove(i);
        }

        try {
            FileOutputStream fos = new FileOutputStream(dataName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(buchungList);

            oos.close();
            fos.close();

            return true;
        }
        catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
