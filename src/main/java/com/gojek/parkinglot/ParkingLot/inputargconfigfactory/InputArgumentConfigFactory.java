package com.gojek.parkinglot.ParkingLot.inputargconfigfactory;

import com.gojek.parkinglot.ParkingLot.Exception.InternalServerErrorException;
import com.gojek.parkinglot.ParkingLot.Exception.NotFoundException;

public class InputArgumentConfigFactory {

	public static void getInputParserConfig(String string) throws NotFoundException, InternalServerErrorException {
		if(string.isEmpty()) {
			new InputArgumentParser();
		}
		else {
			new FileParser(string);
		}
	}
}
