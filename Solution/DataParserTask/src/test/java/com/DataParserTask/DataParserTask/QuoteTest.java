package com.DataParserTask.DataParserTask;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QuoteTest {

	@Test
	/*
	 * Test Quote Data Extracted Correctly
	 */
	public void QuoteExtraction_Test() throws StreamReadException, DatabindException, IOException {
		String directoryPath = System.getProperty("user.dir");
		File jsonFile = new File(directoryPath+"/src/test/resources/Quote_Data_Test");
		ObjectMapper objectMapper = new ObjectMapper();
		Quote quote = objectMapper.readValue(jsonFile, Quote.class);
		
		Quote expectedOutput = new Quote("Data Parser Task", 1573599600000L, new ArrayList<OrderDetails>(Arrays.asList(
				new OrderDetails("Yasmeen","ElKararty","4511","none",23,false,"none",null,0),
				new OrderDetails("Valeo","noLabel","01","none",1,false,"none",null,0))));
		

		assertEquals(expectedOutput.getMarket(),quote.getMarket());
		assertEquals(expectedOutput.getDate_applied(),quote.getDate_applied());
		assertEquals(expectedOutput.getValues().toString(),quote.getValues().toString());
	}
	@Test
	/*
	 * Test Date read in MS is converted to date correctly
	 */
	public void DateConverterFromMStoDate_Test() {
		Quote quote = new Quote();
		quote.setDate_applied(1717262608626L);
		Date output = quote.DateConverterFromMStoDate();
		assertEquals(new Date(1717262608626L),output);
	}
	@Test
	/*
	 * Test Quote Data Extracted time zone conversion occurs successfully
	 */
	public void NetherlandsTimeZoneConverter_Test() throws ParseException {
		Quote quote = new Quote();
		quote.setDate_applied(1717262608626L);
		String output = quote.NetherlandsTimeZoneConverter(quote.DateConverterFromMStoDate(),"GMT+2");
		assertEquals("Sat Jun 01 19:23:28 GMT+02:00 2024",output);
	}

}
