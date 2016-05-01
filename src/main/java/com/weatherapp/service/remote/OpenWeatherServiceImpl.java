package com.weatherapp.service.remote;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapp.model.WeatherData;
import com.weatherapp.service.remote.model.OpenWeatherServiceData;
import com.weatherapp.utilities.DateTimeUtil;
import com.weatherapp.utilities.UnitUtil;

/**
 * @author shiraz
 *	
 *	This class communicates with the third party weather service and implements RemoteWeatherServiceInterface
 */
@Service
public class OpenWeatherServiceImpl implements RemoteWeatherServiceInterface {

	@Value("${weather.api.base.url}")
	private String baseURL;

	@Value("${weather.api.api.key}")
	private String apiKey;

	@Value("${weather.api.units}")
	String unit;

	@Override
	public WeatherData getWeatherData(String zip) {
		try {
			StringBuilder urlSB = new StringBuilder();
			urlSB.append(baseURL);
			urlSB.append("?zip=");
			urlSB.append(zip);
			urlSB.append(",au&appid=");
			urlSB.append(apiKey);
			urlSB.append("&units=");
			urlSB.append(unit);
			
			URL svcURL = new URL(urlSB.toString());
			HttpURLConnection conn = (HttpURLConnection) svcURL.openConnection();
			InputStream is = conn.getInputStream();

			ObjectMapper mapper = new ObjectMapper();
			OpenWeatherServiceData openWeatherData = mapper.readValue(is, OpenWeatherServiceData.class);

			is.close();
			conn.disconnect();

			return transform(openWeatherData);

		} catch (IOException e) {
			e.printStackTrace();
			return new WeatherData();
		}
	}

	private WeatherData transform(OpenWeatherServiceData openWeatherData) {

		WeatherData data = new WeatherData();
		
		if(openWeatherData != null){
			data.setTemperature(Integer.toString(Math.round(openWeatherData.getMain().getTemp())) + " " + UnitUtil.getTemperatureUnit());
			data.setCityName(openWeatherData.getName());
			data.setTime(DateTimeUtil.unixTimeToString(openWeatherData.getDt()));
			data.setWeather(openWeatherData.getWeather().get(0).getDescription());
			
			float speed = openWeatherData.getWind().getSpeed();
			if (unit.equals("metric")){
				// to convert to km/h
				speed = Math.round(speed * 60 *60 / 1000);
			}
			
			data.setWind(Integer.toString((int)speed) + " " + UnitUtil.getSpeedUnit());
		}
		
		return data;
	}

}
