package com.weatherapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.weatherapp.model.WeatherData;
import com.weatherapp.service.WeatherServiceInterface;

/**
 * @author shiraz
 *
 *	This controller is used to serve REST web service requests that are sent using AJAX
 */
@RestController
public class WeatherDataRestController {
	
	@Autowired
	private WeatherServiceInterface weatherService;

	@RequestMapping(value = "/data/{zip}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody WeatherData getWeatherData(@PathVariable("zip") String zip) {
		
		WeatherData data = weatherService.getExternalData(zip);
		return data;
	}
	

}
