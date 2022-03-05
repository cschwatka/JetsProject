package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetImpl;

public class JetsApplication {

	public static void main(String[] args) {

		JetsApplication app = new JetsApplication();
		app.run();
	}

	private void run() {

		List<Jet> zJets = importJets(); 	// Read z jets from file
		AirField buckley = new AirField(zJets); // Land the imported jets at Buckley AFB
		
	}	

	
	public void menu() {
		while (true) {
			
		}
	}


	public List<Jet> importJets() {

		List<Jet> importedJets = new ArrayList<>();

		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[0].equals("Passenger")) {

					importedJets.add(new JetImpl(temp[0], (temp[1]), Double.parseDouble(temp[2]),
							Integer.parseInt(temp[3]), Long.parseLong(temp[4])

					));

				} else if (temp[0].equals("Cargo")) {

					importedJets.add(new CargoPlane(temp[0], (temp[1]), Double.parseDouble(temp[2]),
							Integer.parseInt(temp[3]), Long.parseLong(temp[4])

					));

				} else if (temp[0].equals("Fighter")) {

					importedJets.add(new FighterJet(temp[0], (temp[1]), Double.parseDouble(temp[2]),
							Integer.parseInt(temp[3]), Long.parseLong(temp[4])

					));

				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return importedJets;
	}

}
