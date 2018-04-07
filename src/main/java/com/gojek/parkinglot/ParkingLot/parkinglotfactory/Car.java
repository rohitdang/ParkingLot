package com.gojek.parkinglot.ParkingLot.parkinglotfactory;

public class Car {
	String registrationNumber;
	String colour;
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Car(String registrationNumber, String colour) {
		this.registrationNumber = registrationNumber;
		this.colour = colour;
	}
}
