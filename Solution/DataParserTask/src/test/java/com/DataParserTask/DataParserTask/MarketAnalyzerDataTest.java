package com.DataParserTask.DataParserTask;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MarketAnalyzerDataTest {

	@Test
	/*
	 * Test market analyzer data parsed correctly from JSON file to defined object
	 */
	public void MarketAnalyzerDataExtraction_Test() throws StreamReadException, DatabindException, IOException {
		String directoryPath = System.getProperty("user.dir");
		File jsonFile = new File(directoryPath+"/src/test/resources/MarketAnalyzer_Data_Test");
		ObjectMapper objectMapper = new ObjectMapper();
		MarketAnalyzerData marketAnalyzerData = objectMapper.readValue(jsonFile, MarketAnalyzerData.class);
		MarketAnalyzerData expectedOutput = new MarketAnalyzerData();
		expectedOutput.setQuotes(new ArrayList<Quote>(Arrays.asList(new Quote("Data Parser Task",1573599600000L,new ArrayList<OrderDetails>(
				Arrays.asList(new OrderDetails("Yasmeen","ElKararty","4511","none",23,false,"none",null,0),
				new OrderDetails("Valeo","noLabel","01","none",1,false,"none",null,0)))),
				new Quote("Data Parser Task2",1573599600000L,new ArrayList<OrderDetails>(
				Arrays.asList(new OrderDetails("Yasmeen2","noLabel","2","none",0,false,"none",null,0)))))));

		assertEquals(expectedOutput.getQuotes().toString(),marketAnalyzerData.getQuotes().toString());
	}

}
