package model;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class PrIS {
	private ArrayList<Docent> deDocenten;
	private ArrayList<Student> deStudenten;
	private ArrayList<Klas> deKlassen;
	
	/**
	 * De constructor maakt een set met standaard-data aan. Deze data
	 * moet nog vervangen worden door gegevens die uit een bestand worden
	 * ingelezen, maar dat is geen onderdeel van deze demo-applicatie!
	 * 
	 * De klasse PrIS (PresentieInformatieSysteem) heeft nu een meervoudige
	 * associatie met de klassen Docent en Student. Uiteraard kan dit nog veel
	 * verder uitgebreid en aangepast worden! 
	 * 
	 * De klasse fungeert min of meer als ingangspunt voor het domeinmodel. Op
	 * dit moment zijn de volgende methoden aanroepbaar:
	 * 
	 * String login(String gebruikersnaam, String wachtwoord)
	 * Docent getDocent(String gebruikersnaam)
	 * Student getStudent(String gebruikersnaam)
	 * ArrayList<Student> getStudentenVanKlas(String klasCode)
	 * 
	 * Methode login geeft de rol van de gebruiker die probeert in te loggen,
	 * dat kan 'student', 'docent' of 'undefined' zijn! Die informatie kan gebruikt 
	 * worden om in de Polymer-GUI te bepalen wat het volgende scherm is dat getoond 
	 * moet worden.
	 * 
	 */

	public PrIS() {
		deDocenten = new ArrayList<Docent>();
		deStudenten = new ArrayList<Student>();
		deKlassen = new ArrayList<Klas>();
		
		Docent d1 = new Docent("Wim", "geheim");
		Docent d2 = new Docent("Hans", "geheim");
		Docent d3 = new Docent("Jan", "geheim");
		
		d1.voegVakToe(new Vak("TCIF-V1AUI-15", "Analyse en User Interfaces"));
		d1.voegVakToe(new Vak("TICT-V1GP-15", "Group Project"));
		d1.voegVakToe(new Vak("TICT-V1OODC-15", "Object Oriented Design & Construction"));
		
		deDocenten.add(d1);
		deDocenten.add(d2);
		deDocenten.add(d3);
		
	}
	
	public void laadKlas(String filename){
		FileReader fr = null;
		BufferedReader br = null;
		try {	

			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String regel = br.readLine();
			
			Klas k1 = new Klas(filename);
			deKlassen.add(k1);
			
			while (regel != null) {
				String[] values = regel.split(",");
				String nummer = values[0];
				String achternaam = values[1];
				String tussenvoegsel = values[2];
				String voornaam = values[3];
				
				Student l = new Student(nummer, "geheim");
				deStudenten.add(l);
				k1.addStudent(l);
					
				regel = br.readLine();
				
			}
			br.close();
		}catch (IOException fnf) {
			System.out.println("bestand niet gevonden");
		}
	}
	
	public void laadroosterk(String r) {
		
	}
	
	public String login(String gebruikersnaam, String wachtwoord) {
		for (Docent d : deDocenten) {
			if (d.getGebruikersNaam().equals(gebruikersnaam)) {
				if (d.controleerWachtwoord(wachtwoord)) {
					return "docent";
				}
			}
		}
		
		for (Student s : deStudenten) {
			if (s.getGebruikersNaam().equals(gebruikersnaam)) {
				if (s.controleerWachtwoord(wachtwoord)) {
					return "student";
				}
			}
		}
		
		return "undefined";
	}
	
	public Docent getDocent(String gebruikersnaam) {
		Docent resultaat = null;
		
		for (Docent d : deDocenten) {
			if (d.getGebruikersNaam().equals(gebruikersnaam)) {
				resultaat = d;
				break;
			}
		}
		
		return resultaat;
	}
	
	public Student getStudent(String gebruikersnaam) {
		Student resultaat = null;
		
		for (Student s : deStudenten) {
			if (s.getGebruikersNaam().equals(gebruikersnaam)) {
				resultaat = s;
				break;
			}
		}
		return resultaat;
	}
	
	public String getKlas(String klasCode) {
		String resultaat = null;
		
		for(Klas k : deKlassen) {
			resultaat = k.getKlasCode();
		}
		return resultaat;
	}
	
	public ArrayList<Student> getStudentenVanKlas(String klasCode) {
		ArrayList<Student> resultaat = new ArrayList<Student>();
			for(Klas k : deKlassen) {
				for (Student s : k.mijnStudenten) {
					resultaat.add(s);
				}
			}
		return resultaat;
	}
}
