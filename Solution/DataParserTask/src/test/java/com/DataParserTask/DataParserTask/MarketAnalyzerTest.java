package com.DataParserTask.DataParserTask;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

public class MarketAnalyzerTest {

	@Test
	/*
	 * Test Market Analyzer parse JSON Function works correctly to parse JSON file to defined object
	 */
	public void MarketAnalyzerData_ParseJsonData_Test() throws StreamReadException, DatabindException, IOException {
		String directoryPath = System.getProperty("user.dir");
		MarketAnalyzer marketAnalyzer = new MarketAnalyzer(directoryPath+"/src/test/resources/MarketAnalyzer_Data_Test");
		marketAnalyzer.parseJSONFileToObj();
		MarketAnalyzer expectedOutput = new MarketAnalyzer();
		expectedOutput.setParsedMarketData(new MarketAnalyzerData(
				new ArrayList<Quote>(Arrays.asList(new Quote("Data Parser Task",1573599600000L,new ArrayList<OrderDetails>(
				Arrays.asList(new OrderDetails("Yasmeen","ElKararty","4511","none",23,false,"none",null,0),
				new OrderDetails("Valeo","noLabel","01","none",1,false,"none",null,0)))),
				new Quote("Data Parser Task2",1573599600000L,new ArrayList<OrderDetails>(
				Arrays.asList(new OrderDetails("Yasmeen2","noLabel","2","none",0,false,"none",null,0))))))));
		

		assertEquals(expectedOutput.getParsedMarketData().toString(),marketAnalyzer.getParsedMarketData().toString());
	}

}
