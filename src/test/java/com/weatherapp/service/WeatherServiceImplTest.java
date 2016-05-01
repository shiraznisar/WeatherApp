package com.weatherapp.service;

import static org.junit.Assert.*;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weatherapp.model.WeatherData;
import com.weatherapp.service.remote.OpenWeatherServiceImpl;
import com.weatherapp.service.remote.RemoteWeatherServiceInterface;
import com.weatherapp.service.remote.model.Main;
import com.weatherapp.service.remote.model.OpenWeatherServiceData;

@ContextConfiguration("/test-app-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WeatherServiceImplTest {

	@InjectMocks
	@Autowired
	private WeatherServiceImpl weatherService;
	
	@Mock
	private RemoteWeatherServiceInterface remoteWeatherService;

	@PostConstruct
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() {
		Mockito.when(remoteWeatherService.getWeatherData(Mockito.anyString())).thenReturn(sampleData());
		WeatherData data = weatherService.getExternalData("222");
		assertEquals("20", data.getTemperature());
	}

	private WeatherData sampleData(){
		WeatherData data = new WeatherData();
		data.setTemperature("20");
		data.setCityName("Sydney");
		data.setTime("Sunday 10:20 AM");
		data.setWeather("Sunny");
		data.setWind("20");
		return data;
	}
}
