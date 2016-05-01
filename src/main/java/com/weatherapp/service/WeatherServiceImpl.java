package com.weatherapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherapp.model.WeatherData;
import com.weatherapp.service.remote.RemoteWeatherServiceInterface;


/**
 * @author shiraz
 *
 *	Service class implementation that implements WeatherServiceInterface.
 */

@Service
public class WeatherServiceImpl  implements WeatherServiceInterface{

	@Autowired
	private RemoteWeatherServiceInterface remoteWeatherService;

	@Override
	public WeatherData getExternalData(String zip) {
		WeatherData data = remoteWeatherService.getWeatherData(zip);
		return data;
	}
}
