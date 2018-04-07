package com.gojek.parkinglot.ParkingLot.parkinglotfactory;

import com.gojek.parkinglot.ParkingLot.Exception.InternalServerErrorException;
import com.gojek.parkinglot.ParkingLot.Exception.NotFoundException;
import com.gojek.parkinglot.ParkingLot.inputargconfigfactory.ParkingLotConfig;

public class Status extends ParkingLotConfig {

	@Override
	public void runTheCommand(String[] commandArray) throws InternalServerErrorException {
		try {
			if(!parking_lot.isEmpty() || parking_lot != null) {
				System.out.println("Slot No.\tRegistration No.\tColor");
				Car car;
				for (int i = 1; i <= parking_lot.size(); i++) {
					if (parking_lot.containsKey(i)) {
						car = parking_lot.get(i);
						System.out.println(i + "\t" + car.getRegistrationNumber() + "\t" + car.getColour());
					}
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