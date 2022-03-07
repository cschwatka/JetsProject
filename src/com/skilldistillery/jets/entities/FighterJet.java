package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements Fightable {

	public FighterJet(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}

	public void fight() {
		System.out.println("pew pew..");
	}

}
