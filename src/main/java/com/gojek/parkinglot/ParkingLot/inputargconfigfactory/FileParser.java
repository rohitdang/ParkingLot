package com.gojek.parkinglot.ParkingLot.inputargconfigfactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.gojek.parkinglot.ParkingLot.Exception.InternalServerErrorException;
import com.gojek.parkinglot.ParkingLot.Exception.NotFoundException;
import com.gojek.parkinglot.ParkingLot.parkinglotfactory.ParkingLotConfigFactory;

public class FileParser {

	private BufferedReader bufferedReader;

	public FileParser(String string) throws NotFoundException, InternalServerErrorException {
		try {
			bufferedReader = new BufferedReader(new FileReader(string));
			String command;
			while ((command = bufferedReader.readLine()) != null) {
				final ParkingLotConfig deployer = ParkingLotConfigFactory.getParkingLotConfig(command);
				String[] commandArray = command.split(" ");
				deployer.runTheCommand(commandArray);
			}
		} catch (IOException e) {
			throw new InternalServerErrorException(e.getMessage(), e);
		}
	}

}
