package com.weatherapp.service;

import com.weatherapp.model.WeatherData;

/**
 * @author shiraz
 *
 *	This interface shoould be implemented by service class.
 */
public interface WeatherServiceInterface {

	WeatherData getExternalData(String zip);

}
