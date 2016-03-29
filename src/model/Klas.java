package model;

import java.util.ArrayList;

public class Klas {
	private String klasCode;
	
	ArrayList<Student> mijnStudenten = new ArrayList<Student>();
	
	public Klas(String kC) {
		klasCode = kC;
	}
	
	public String getKlasCode() {
		return klasCode;
	}
	
	public void addStudent(Student s) {
		mijnStudenten.add(s);
	}
	
	public Student getStudenten() {
		Student l = null;
		for (Student s : mijnStudenten) {
			l = s;
		}
		return l;
	}
}
