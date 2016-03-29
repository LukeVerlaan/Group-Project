package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Les {
	
	public Les() {
		
	}
	
	public void laadLessen(String l) {
		try {
			FileReader fr = new FileReader("rooster_c.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String regel = br.readLine();
			
			while (regel != null) {
				String[] values = regel.split(",");
				String datum = values[0];
				String beginTijd = values[1];
				String eindTijd = values[2];
				String vakcode = values[3];
				String docent = values[4];
				String lokaal = values[5];
			}
				
		} catch (FileNotFoundException fnf) {
			System.out.print("bestand niet gevonden");
		} catch (IOException ioe) {
			System.out.println("IO fout");
		}
	}
	
}
