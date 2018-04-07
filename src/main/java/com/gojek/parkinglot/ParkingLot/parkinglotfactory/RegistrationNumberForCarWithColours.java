package com.gojek.parkinglot.ParkingLot.parkinglotfactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.gojek.parkinglot.ParkingLot.Exception.InternalServerErrorException;
import com.gojek.parkinglot.ParkingLot.Exception.NotFoundException;
import com.gojek.parkinglot.ParkingLot.inputargconfigfactory.ParkingLotConfig;

public class RegistrationNumberForCarWithColours extends ParkingLotConfig {

	@Override
	public void runTheCommand(String[] commandArray) throws InternalServerErrorException {
		try {
			if(!parking_lot.isEmpty() || parking_lot != null) {
				String colour = commandArray[1];
				boolean flag = false;
				Collection<Car> allCars = parking_lot.values();
				List<String> regList = new ArrayList<>();
				for (Car car : allCars) {
					if (car.getColour().equals(colour)) {
						flag = true;
						regList.add(car.getRegistrationNumber());
					}
				}
				if(flag == false) {
					System.out.print("Not Found");
				} else {
					System.out.println(String.join(",", regList));
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
