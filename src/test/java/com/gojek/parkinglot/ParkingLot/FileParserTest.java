package com.gojek.parkinglot.ParkingLot;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.parkinglot.ParkingLot.Exception.InternalServerErrorException;
import com.gojek.parkinglot.ParkingLot.Exception.NotFoundException;
import com.gojek.parkinglot.ParkingLot.inputargconfigfactory.FileParser;

public class FileParserTest {
	private PrintStream console;
	private ByteArrayOutputStream bytes;

	@Before
	public void setUp() {
		bytes   = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(bytes));
	}

	@After
	public void tearDown() {
		System.setOut(console);
	}

	@Test
	public void testValidFileParsing() throws NotFoundException, InternalServerErrorException {
		new FileParser("./src/test/resources/file_inputs_valid.txt");
		String output =  "Created a parking lot with 6 slots\n" + 
				"Allocated slot number:1\n" + 
				"Allocated slot number:2\n" + 
				"Allocated slot number:3\n" + 
				"Allocated slot number:4\n" + 
				"Allocated slot number:5\n" + 
				"Allocated slot number:6\n" + 
				"Slot number 4 is free\n" + 
				"Slot No.	Registration No.	Color\n" + 
				"1	KA-01-HH-1234	White\n" + 
				"2	KA-01-HH-9999	White\n" + 
				"3	KA-01-BB-0001	Black\n" + 
				"5	KA-01-HH-2701	Blue\n" + 
				"Allocated slot number:4\n"+ 
				"Sorry, parking lot is full\n" + 
				"KA-01-HH-1234,KA-01-HH-9999,KA-01-P-333\n"+
				"1,2,4\n" +  
				"6\n" + 
				"Not found";
		assertEquals(output, bytes.toString());
	}
	
	@Test(expected = NotFoundException.class)
	public void testInvalidFileParsing() throws NotFoundException, InternalServerErrorException {
		new FileParser("./src/test/resources/file_input_invalid.txt");
	}
	
	@Test(expected = NotFoundException.class)
	public void testNoParKingLotFileParsing() throws NotFoundException, InternalServerErrorException {
		new FileParser("./src/test/resources/file_input_invalid.txt");
	}

}
