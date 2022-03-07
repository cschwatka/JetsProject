package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {

	private List<Jet> jets = new ArrayList<>();

	// CONSTRUCTORS

	public AirField(List<Jet> jets) {
		super();
		this.jets = jets;
	}

	// OTHER ACTION METHODS

	public List<Jet> getJets() {
		return jets;
	}
	
	public List<Jet> removeJets() {
		Scanner sc = new Scanner(System.in);
		
		for (Jet jet : jets) {
			System.out.println("Number: " + (jets.indexOf(jet)+1) + "  ("+ jet.getModel() +")");
		}
		
		System.out.println("\n**** Which jet # do you want to remove? ****");
		int input = sc.nextInt();
		
		System.out.println("We just removed: \n" + jets.get(input-1));
		
		jets.remove(input-1);
		
		return jets;
	}
	

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}
	
	public void addJet(Jet jet) {
		this.jets.add(jet);
	}

	public void fastestJet() {
		double max = 0.0;
		int maxIndex = 0;
		for (Jet jet : jets) {
			if (jet.getSpeed() > max) {
				max = jet.getSpeed();
				maxIndex = jets.indexOf(jet);
			}
		}
		System.out.println("The fastest jet is: " + jets.get(maxIndex) );
	
	}
	public void longestRange() {
		double maxRange = 0;
		int maxIndexRange = 0;
		for (Jet jet : jets) {
			if (jet.getRange() > maxRange) {
				maxRange = jet.getRange();
				maxIndexRange = jets.indexOf(jet);
			}
		}
		System.out.println("Longest range jet: " + jets.get(maxIndexRange) );
	
	}

	public void flyJets() {

		for (Jet jet : jets) {
			System.out.printf(jet.getModel() + "\tRange(miles): " + jet.getRange() +"\t" + "Speed(mph): " + jet.getSpeed() +"\t"
					 + "Flight Time(hrs): %.2f %n", jet.getRange() / jet.getSpeed());

		}
	}

	public String listJets() {
		return "AirField [jets=" + jets + "]";
	}

	@Override
	public String toString() {
		return "AirField [jets=" + jets + "]";
	}

	public void listCargos() {
		for (Jet jet : jets) {
			if (jet instanceof Loadable) {
				System.out.println("Loading: " + jet);
			}
		}
	}
		
	public void dogFight() {
		for (Jet jet : jets) {
			if (jet instanceof Fightable) {
				System.out.println("Dog Fighting! Pew pew! " + jet);
			}
		}
	}

}
