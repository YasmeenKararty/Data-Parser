package com.DataParserTask.DataParserTask;

import java.io.IOException;
import java.text.ParseException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;


public class Main 
{
    public static void main( String[] args ) throws StreamReadException, DatabindException, IOException, ParseException
    {
    	String directoryPath = System.getProperty("user.dir");
    	MarketAnalyzer marketAnalyzer = new MarketAnalyzer(directoryPath + "/src/main/resources/apx-data.json");
    	marketAnalyzer.parseJSONFileToObj();
    	marketAnalyzer.AnalyzeMarketData();
    	
    }
}
