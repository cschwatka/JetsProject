package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements Loadable {
	

	
	
	// CONSTRUCTORS

	public CargoPlane(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}
	
	
	// METHODS
	
	public void loadCargo() {
		System.out.println("Cargo loaded for: " + super.getModel());
	}

}
