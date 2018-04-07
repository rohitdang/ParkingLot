package com.gojek.parkinglot.ParkingLot;

import org.junit.Assert;
import org.junit.Test;

import com.gojek.parkinglot.ParkingLot.Exception.NotFoundException;
import com.gojek.parkinglot.ParkingLot.parkinglotfactory.CreateParkingLot;
import com.gojek.parkinglot.ParkingLot.parkinglotfactory.Leave;
import com.gojek.parkinglot.ParkingLot.parkinglotfactory.Park;
import com.gojek.parkinglot.ParkingLot.parkinglotfactory.ParkingLotConfigFactory;
import com.gojek.parkinglot.ParkingLot.parkinglotfactory.Status;

/**
 * Unit test for simple App.
 */
public class ConfigFactoryTest {
   
	@Test
	   public void testConfigFactory() throws NotFoundException {	
		Assert.assertTrue((ParkingLotConfigFactory.getParkingLotConfig("create_parking_lot") instanceof CreateParkingLot));
		Assert.assertFalse((ParkingLotConfigFactory.getParkingLotConfig("create_parking_lot") instanceof Leave));
		Assert.assertTrue((ParkingLotConfigFactory.getParkingLotConfig("leave") instanceof Leave));
		Assert.assertFalse((ParkingLotConfigFactory.getParkingLotConfig("leave") instanceof Status));
		Assert.assertTrue((ParkingLotConfigFactory.getParkingLotConfig("status") instanceof Status));
		Assert.assertFalse((ParkingLotConfigFactory.getParkingLotConfig("status") instanceof Park));
		Assert.assertTrue((ParkingLotConfigFactory.getParkingLotConfig("park") instanceof Park));
		Assert.assertFalse((ParkingLotConfigFactory.getParkingLotConfig("park") instanceof Leave));
		Assert.assertFalse((ParkingLotConfigFactory.getParkingLotConfig("park") instanceof Status));     
	   }
}
