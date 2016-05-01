package com.weatherapp.controller;

import javax.annotation.PostConstruct;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weatherapp.model.WeatherData;
import com.weatherapp.service.WeatherServiceInterface;

@ContextConfiguration("/test-app-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WeatherDataRestControllerTest {

	@InjectMocks
	@Autowired
	private WeatherDataRestController controller;
	
	@Mock
	private WeatherServiceInterface weatherService;
	
	@PostConstruct
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() {
		Mockito.when(weatherService.getExternalData(Mockito.anyString())).thenReturn(sampleData());
		WeatherData actual =  controller.getWeatherData("2000");
		if(actual!=null){
			Assert.assertEquals("10", actual.getTemperature());
			Assert.assertEquals("Sydney", actual.getCityName());
			
		}else{
			Assert.fail("unable to run test");
		}
	}

	private WeatherData sampleData(){
		WeatherData data = new WeatherData();
		data.setTemperature("10");
		data.setCityName("Sydney");
		data.setTime("Sunday 10:20 AM");
		data.setWeather("Sunny");
		data.setWind("20");
		return data;
	}
	
}
