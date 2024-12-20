package com.DataParserTask.DataParserTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
	@JsonProperty("market")
	private String market;
	@JsonProperty("date_applied")
	private long date_applied;
	@JsonProperty("values")
	private List<OrderDetails> values;
	
	/*Constructors*/
	public Quote() {
		
	}
	public Quote(String market, long date_applied,
			List<OrderDetails> values) {
		this.market = market;
		this.date_applied = date_applied;
		this.values = values;
	}
	/*End Of Constructors*/
	
	/*Getters And Setters*/
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public long getDate_applied() {
		return date_applied;
	}
	public void setDate_applied(long date_applied) {
		this.date_applied = date_applied;
	}
	public List<OrderDetails> getValues() {
		return values;
	}
	public void setValues(List<OrderDetails> values) {
		this.values = values;
	}
	/*End Of Getters And Setters*/
	
	//Method to convert date in MS to Date
	public Date DateConverterFromMStoDate(){
		Date date = new Date(this.getDate_applied());
		return date;
	}
	
	/*
	 * Method to convert input Date to Netherlands TimeZone (GMT+2)
	 * Input: 
	 * date: the date to be converted
	 * timeZone: the time zone the date is to be converted to
	 * Output: 
	 * formattedDate: string with the converted date in the specified time zone
	 */
	public String NetherlandsTimeZoneConverter(Date date, String timeZone) {
		SimpleDateFormat obj = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyy");   
		obj.setTimeZone(TimeZone.getTimeZone(timeZone));
		String formattedDate = obj.format(date);
		return formattedDate;
		
	}
	
	/*
	 * Method to extract the date from parsed JSON
	 * Output: 
	 * string parsed from the JSON file after converting it to the specified time zone
	 */
	public String extractDate() {
		return this.NetherlandsTimeZoneConverter(this.DateConverterFromMStoDate(),"GMT+2");
	}
	
	/*
	 * Method to extract the hour of the day from parsed JSON
	 * Output: 
	 * string holding hour of the day parsed from the JSON file 
	 * if not eligible invalid message to be returned 
	 */
	
	public String extractHourOfDay() {
		for (OrderDetails value : values) {
			if(value.gettLabel().equals("Order") || value.gettLabel().equals("Hour")) {
				return value.getValue();
			}
		}
		return "Invalid Hour Of Day";
	
	}
	
	/*
	 * Method to extract the net volume from parsed JSON
	 * Output: 
	 * string holding the net volume parsed from the JSON file 
	 * if not eligible invalid message to be returned 
	 */
	
	public String extractNetVolume() {
		for (OrderDetails value : values) {
			if(value.getcLabel().equals("Volume")) {
				return value.getValue()+value.getUnit();
			}
		}
		return "Invalid Net Volume";
	}
	
	/*
	 * Method to extract the price from parsed JSON
	 * Output: 
	 * string holding the price parsed from the JSON file 
	 * if not eligible invalid message to be returned 
	 */
	
	public String extractPrice() {
		for (OrderDetails value : values) {
			if(value.getcLabel().equals("Price")) {
				return value.getValue()+value.getUnit();
			}
		}
		return "Invalid Price";
	}
	@Override
	public String toString() {
		return "Quote [market=" + market + ", date_applied=" + date_applied + ", values=" + values + "]";
	}
	
}
