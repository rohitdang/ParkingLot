package com.gojek.parkinglot.ParkingLot.parkinglotfactory;

import java.util.ArrayList;

import com.gojek.parkinglot.ParkingLot.Exception.InternalServerErrorException;
import com.gojek.parkinglot.ParkingLot.inputargconfigfactory.ParkingLotConfig;

public class CreateParkingLot extends ParkingLotConfig {

	@Override
	public void runTheCommand(String[] commandArray) throws InternalServerErrorException {
		try {
			Integer parkingLotSpace = Integer.parseInt(commandArray[1]);
			ArrayList<Integer> placesInGarrage = new ArrayList<>();
			for (int i = 1; i <= parkingLotSpace; i++) {
				placesInGarrage.add(i);
			}
			places_left = placesInGarrage;
			total_size_alloted = parkingLotSpace;
			System.out.println("Created a parking lot with "+parkingLotSpace+" slots");
		}
		catch (Exception e) {
			throw new InternalServerErrorException(e.getMessage(), e);
		}
	}
}