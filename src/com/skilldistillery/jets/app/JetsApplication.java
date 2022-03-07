package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

	public void run() {

		List<Jet> zJets = importJets(); // Read z jets from file
		AirField buckley = new AirField(zJets); // Land the imported jets at Buckley AFB
		
		Scanner sc = new Scanner(System.in);
		int choice;

		while (true) {
			System.out.println("\n\nJets Main Menu\n");
			System.out.print("1.) List fleet \n");
			System.out.print("2.) Fly all jets \n");
			System.out.print("3.) View fastest jet\n");
			System.out.print("4.) View jet with longest range\n");
			System.out.print("5.) Load all Cargo Jets \n");
			System.out.print("6.) Dogfight! \n");
			System.out.print("7.) Add a jet to fleet \n");
			System.out.print("8.) Remove a jet from fleet \n");
			System.out.print("9.) Quit \n");

			System.out.print("\nEnter Your Menu Choice: ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Listing the jets...");
				for (int i = 0; i < buckley.getJets().size(); i++) {
					Jet n = buckley.getJets().get(i);
					System.out.println(n);
				}
				break;
			case 2:
				buckley.flyJets();
				break;
			case 3:
				buckley.fastestJet();
				break;
			case 4:
				buckley.longestRange();
				break;
			case 5:
				buckley.listCargos();
				break;
			case 6:
				buckley.dogFight();
				break;
			case 7:
				System.out.println("Enter Type (Fighter, Cargo, or something else):  ");
				String tempType = sc.next();
				sc.nextLine(); // clear buffer
				System.out.println("Enter Model:  ");
				String tempModel = sc.nextLine();
				System.out.println("Enter Speed(mph):  ");
				double tempSpeed = sc.nextDouble();
				System.out.println("Enter Range(miles, as integer):  ");
				int tempRange = sc.nextInt();

				System.out.println("Enter Price(dollars, as integer):  ");
				long tempPrice = sc.nextInt();
				System.out.println("\nAdded new jet to airfield...");

				if (tempType.equals("Fighter")) {
					Jet newJet = new FighterJet(tempType, tempModel, tempSpeed, tempRange, tempPrice);
					buckley.addJet(newJet);
				} else if (tempType.equals("Cargo")) {
					Jet newJet = new CargoPlane(tempType, tempModel, tempSpeed, tempRange, tempPrice);
					buckley.addJet(newJet);
				} else {
					Jet newJet = new JetImpl(tempType, tempModel, tempSpeed, tempRange, tempPrice);
					buckley.addJet(newJet);
				}
				break;
			case 8:

				buckley.removeJets();

				break;
			case 9:
				System.out.println("Exiting Program...Good riddance");
				System.exit(0);
				break;

			default:
				System.out.println("Not a valid input, try again.");
				break;
			}
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
