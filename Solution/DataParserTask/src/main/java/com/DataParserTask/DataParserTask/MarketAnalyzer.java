package com.DataParserTask.DataParserTask;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MarketAnalyzer {

	private MarketAnalyzerData parsedMarketData;
	private String JSONFileName;
	
	/*Constructors*/
	public MarketAnalyzer() {
	}
	public MarketAnalyzer(String JSONFileName) {
		this.JSONFileName = JSONFileName;
	}
	/*End of Constructors*/
	
	/*
	 * Method to parse the JSON file defined to applicable object
	 */
	public void parseJSONFileToObj() throws StreamReadException, DatabindException, IOException {
		File jsonFile = new File(this.JSONFileName);
		ObjectMapper objectMapper = new ObjectMapper();
		this.setParsedMarketData(objectMapper.readValue(jsonFile, MarketAnalyzerData.class));
		
	}

	/*
	 * Method to analyze (print only for now) market data extracted from the JSON File
	 */
	public void AnalyzeMarketData() throws StreamReadException, DatabindException, IOException, ParseException {
		for (Quote quote : this.parsedMarketData.getQuotes()) {
			System.out.println("Date: "+quote.extractDate());
			System.out.println("Market: "+quote.getMarket());
			System.out.println("Hour Of the Day: "+quote.extractHourOfDay());
			System.out.println("Net Volume: "+quote.extractNetVolume());
			System.out.println("Price: "+quote.extractPrice());
			System.out.println("------------------------------------------------");
		}
		
	}
	/*Start of Getters and Setters*/
	public MarketAnalyzerData getParsedMarketData() {
		return parsedMarketData;
	}

	public void setParsedMarketData(MarketAnalyzerData parsedMarketData) {
		this.parsedMarketData = parsedMarketData;
	}
	/*End of Getters and Setters*/
	
}
