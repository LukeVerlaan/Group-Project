package model;

public class Student {
	private String gebruikersNaam;
	private String wachtwoord;
	
	public Student(String gbNm, String ww) {
		gebruikersNaam = gbNm;
		wachtwoord = ww;
	}
	
	public String getGebruikersNaam() {
		return gebruikersNaam;
	}
	
	public boolean controleerWachtwoord(String ww) {
		return ww.equals(wachtwoord);
	}
}
