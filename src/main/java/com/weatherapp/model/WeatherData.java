package com.weatherapp.model;

import java.io.Serializable;


/**
 * @author shiraz
 *	
 *	POJO which will contain weather response data
 */
public class WeatherData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2344492853805457209L;

	
	private String cityName;
	private String time;
	private String weather;
	private String temperature;
	private String wind;
	private String status;
	
	public WeatherData(){
		this.cityName = "N/A";
		this.time = "N/A";
		this.weather = "N/A";
		this.temperature = "N/A";
		this.weather = "N/A";
	}
	
	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temp) {
		this.temperature = temp;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}
}
