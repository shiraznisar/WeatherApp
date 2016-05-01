package com.weatherapp.service.remote;

import com.weatherapp.model.WeatherData;

/**
 * @author shiraz
 *	
 *	The purpose of this interface is to implement the remote weather service keeping in view of the SOLID principle. 
 */
public interface RemoteWeatherServiceInterface {

	WeatherData getWeatherData(String zip);
}
