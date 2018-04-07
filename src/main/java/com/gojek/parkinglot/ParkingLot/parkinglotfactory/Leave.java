package com.gojek.parkinglot.ParkingLot.parkinglotfactory;

import java.util.ArrayList;
import java.util.Collections;

import com.gojek.parkinglot.ParkingLot.Exception.InternalServerErrorException;
import com.gojek.parkinglot.ParkingLot.inputargconfigfactory.ParkingLotConfig;

public class Leave extends ParkingLotConfig {

	@Override
	public void runTheCommand(String[] commandArray) throws InternalServerErrorException {
		try {
			if(!parking_lot.isEmpty() || parking_lot != null) {
				Integer parkingLotSpaceNumber = Integer.parseInt(commandArray[1]);
				parking_lot.remove(parkingLotSpaceNumber);
				System.out.println("Slot number "+parkingLotSpaceNumber+" is free");
				ArrayList<Integer> placesLeft = places_left;
				placesLeft.add(parkingLotSpaceNumber);
				Collections.sort(placesLeft);
				places_left = placesLeft;
			} 
			else {

			}
		}

		catch (Exception e) {
			throw new InternalServerErrorException(e.getMessage(), e);
		}
	}	
}
