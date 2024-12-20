package com.DataParserTask.DataParserTask;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderDetailsTest {

	@Test
	/*
	 * Test Order Details parsed correctly from JSON file to defined object
	 */
	public void OrderDetails_Test() throws StreamReadException, DatabindException, IOException {
		String directoryPath = System.getProperty("user.dir");
		File jsonFile = new File(directoryPath+"/src/test/resources/OrderDetails_Data_Test");
		ObjectMapper objectMapper = new ObjectMapper();
		OrderDetails order = objectMapper.readValue(jsonFile, OrderDetails.class);
		assertEquals("Yasmeen",order.gettLabel());
		assertEquals("ElKararty",order.getcLabel());
		assertEquals("4511",order.getValue());
		assertEquals("none",order.getUnit());
		assertEquals(23,order.getPosition());
		assertEquals(false,order.getChartShow());
		assertEquals("none",order.getChartType());
		assertEquals(null,order.getColor());
		assertEquals(0,order.getPrecision());
	}
}
