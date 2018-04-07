package com.gojek.parkinglot.ParkingLot.inputargconfigfactory;

import java.util.ArrayList;
import java.util.HashMap;

import com.gojek.parkinglot.ParkingLot.Exception.InternalServerErrorException;
import com.gojek.parkinglot.ParkingLot.parkinglotfactory.Car;

public abstract class ParkingLotConfig {



	public static ArrayList<Integer> places_left;
	public static int total_size_alloted;
	public static HashMap<Integer, Car> parking_lot = new HashMap<>();
	public abstract void runTheCommand(String[] commandArray) throws InternalServerErrorException;
}
