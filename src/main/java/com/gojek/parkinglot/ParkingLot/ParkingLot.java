package com.gojek.parkinglot.ParkingLot;

import com.gojek.parkinglot.ParkingLot.Exception.InternalServerErrorException;
import com.gojek.parkinglot.ParkingLot.Exception.NotFoundException;
import com.gojek.parkinglot.ParkingLot.inputargconfigfactory.InputArgumentConfigFactory;

public class ParkingLot {
	
	public static void main( String[] args ) throws NotFoundException, InternalServerErrorException {
		if(args.length != 0 ) {
			InputArgumentConfigFactory.getInputParserConfig(args[0]);	
		} else {
			InputArgumentConfigFactory.getInputParserConfig("");
		}
	}
}