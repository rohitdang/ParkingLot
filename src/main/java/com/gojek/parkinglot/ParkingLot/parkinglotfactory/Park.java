package com.gojek.parkinglot.ParkingLot.parkinglotfactory;

import java.util.List;

import com.gojek.parkinglot.ParkingLot.Exception.InternalServerErrorException;
import com.gojek.parkinglot.ParkingLot.Exception.NotFoundException;
import com.gojek.parkinglot.ParkingLot.inputargconfigfactory.ParkingLotConfig;

public class Park extends ParkingLotConfig {

	@Override
	public void runTheCommand(String[] commandArray) throws InternalServerErrorException {
		try {
			if(!parking_lot.isEmpty() || parking_lot != null) {
				Car car = new Car(commandArray[1], commandArray[2]);
				List<Integer> totalPlacesLeft = places_left;
				if(totalPlacesLeft.isEmpty()) {
					System.out.println("Sorry, parking lot is full");
				} else {
					Integer parkingSlot = totalPlacesLeft.get(0);
					if(totalPlacesLeft.size() <= total_size_alloted ) {
						parking_lot.put(parkingSlot, car);	
					} 
					System.out.println("Allocated slot number:"+ parkingSlot);
					totalPlacesLeft.remove(0);
				}
			}
			else {
				throw new NotFoundException("Parking Lot Not Found. Create one first");
			}

		}
		catch (Exception e) {
			throw new InternalServerErrorException(e.getMessage(), e);
		}
	}
}
