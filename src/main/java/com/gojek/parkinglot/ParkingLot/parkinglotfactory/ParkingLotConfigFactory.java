package com.gojek.parkinglot.ParkingLot.parkinglotfactory;

import com.gojek.parkinglot.ParkingLot.Exception.NotFoundException;
import com.gojek.parkinglot.ParkingLot.inputargconfigfactory.ParkingLotConfig;

public class ParkingLotConfigFactory {

	public static ParkingLotConfig getParkingLotConfig(String command) throws NotFoundException {				
		
		if (command.contains("create_parking_lot"))
		{
			return new CreateParkingLot();
		}
		else if (command.contains("park"))
		{
			return new Park();				
		}
		else if (command.contains("leave"))
		{
			return new Leave();				
		}
		else if (command.contains("status"))
		{
			return new Status();				
		}
		else if (command.contains("registration_numbers_for_cars_with_colour"))
		{
			return new RegistrationNumberForCarWithColours();				
		}
		else if (command.contains("slot_numbers_for_cars_with_colour"))
		{
			return new SlotNumberForCarWithColours();				
		}
		else if (command.contains("slot_number_for_registration_number"))
		{
			return new SlotNumberForCarWithRegistrationNumber();				
		} 
		else
		{
			throw new NotFoundException("Command Not Found")	;
		}
		
	}
}