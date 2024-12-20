package com.DataParserTask.DataParserTask;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketAnalyzerData {
	@JsonProperty("quote")
	private List<Quote> quotes;
	
	/*Constructors*/
	public MarketAnalyzerData() {
		
	}
	public MarketAnalyzerData(List<Quote> quotes) {
		this.quotes = quotes;
	}
	/*End of Constructors*/
	
	/*Start of Getters and Setters*/
	public List<Quote> getQuotes() {
		return quotes;
	}
	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}
	/*End of Getters and Setters*/
	
	@Override
	public String toString() {
		return "MarketAnalyzerData [quotes=" + quotes + "]";
	}
	
}
