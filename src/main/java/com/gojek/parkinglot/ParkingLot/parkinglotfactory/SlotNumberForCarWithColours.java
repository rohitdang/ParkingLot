package com.gojek.parkinglot.ParkingLot.parkinglotfactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import com.gojek.parkinglot.ParkingLot.Exception.InternalServerErrorException;
import com.gojek.parkinglot.ParkingLot.Exception.NotFoundException;
import com.gojek.parkinglot.ParkingLot.inputargconfigfactory.ParkingLotConfig;

public class SlotNumberForCarWithColours extends ParkingLotConfig {

	@Override
	public void runTheCommand(String[] commandArray) throws InternalServerErrorException {
		try {
			if(!parking_lot.isEmpty() || parking_lot != null) {
				String colour = commandArray[1];
				boolean flag = true;
				Collection<Car> allCars = parking_lot.values();
				List<String> slotNum = new ArrayList<>();
				for (Car car : allCars) {
					if (car.getColour().equals(colour)) {
						for (Entry<Integer, Car> entry : parking_lot.entrySet()) {
							if (entry.getValue().equals(car)) {
								flag = true;
								String key = entry.getKey().toString();
								slotNum.add(key);
							}
						}
					}
				}
				if(flag == false) {
					System.out.print("Not found");
				} else {
					System.out.println(String.join(",", slotNum));
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