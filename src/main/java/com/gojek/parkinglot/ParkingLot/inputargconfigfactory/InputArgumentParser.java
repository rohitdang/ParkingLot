package com.gojek.parkinglot.ParkingLot.inputargconfigfactory;

import java.util.Scanner;

import com.gojek.parkinglot.ParkingLot.Exception.InternalServerErrorException;
import com.gojek.parkinglot.ParkingLot.Exception.NotFoundException;
import com.gojek.parkinglot.ParkingLot.parkinglotfactory.ParkingLotConfigFactory;

public class InputArgumentParser {
	public InputArgumentParser() throws NotFoundException, InternalServerErrorException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			System.out.println("Input: ");
			String command = scanner.nextLine();
			final ParkingLotConfig deployer = ParkingLotConfigFactory.getParkingLotConfig(command);
			System.out.println("OutPut: ");
			String[] commandArray = command.split("\\s+");
			deployer.runTheCommand(commandArray);
		}
	}
}

