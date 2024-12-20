package com.DataParserTask.DataParserTask;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDetails {
	@JsonProperty("tLabel")
	private String tLabel;
	@JsonProperty("cLabel")
	private String cLabel;
	@JsonProperty("value")
	private String value;
	@JsonProperty("unit")
	private String unit;
	@JsonProperty("position")
	private int position;
	@JsonProperty("chartShow")
	private boolean chartShow;
	@JsonProperty("chartType")
	private String chartType;
	@JsonProperty("color")
	private String color;
	@JsonProperty("precision")
	private int precision;
	
	/*Constructors*/
	public OrderDetails() {
		
	}
	public OrderDetails(String tLabel, String cLabel, String value, String unit, int position, boolean chartShow,
			String chartType, String color, int precision) {
		this.tLabel = tLabel;
		this.cLabel = cLabel;
		this.value = value;
		this.unit = unit;
		this.position = position;
		this.chartShow = chartShow;
		this.chartType = chartType;
		this.color = color;
		this.precision = precision;
	}
	/*End of Constructors*/
	
	/*Start of Getters And Setters*/
	public String gettLabel() {
		return tLabel;
	}
	public void settLabel(String tLabel) {
		this.tLabel = tLabel;
	}
	public String getcLabel() {
		return cLabel;
	}
	public void setcLabel(String cLabel) {
		this.cLabel = cLabel;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public boolean getChartShow() {
		return chartShow;
	}
	public void setChartShow(boolean chartShow) {
		this.chartShow = chartShow;
	}
	public String getChartType() {
		return chartType;
	}
	public void setChartType(String chartType) {
		this.chartType = chartType;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrecision() {
		return precision;
	}
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	/*End of Getters And Setters*/
	
	@Override
	public String toString() {
		return "OrderDetails [tLabel=" + tLabel + ", cLabel=" + cLabel + ", value=" + value + ", unit=" + unit
				+ ", position=" + position + ", chartShow=" + chartShow + ", chartType=" + chartType + ", color="
				+ color + ", precision=" + precision + "]";
	}
		
	
	

}
