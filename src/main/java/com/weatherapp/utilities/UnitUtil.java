package com.weatherapp.utilities;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author shiraz
 *
 *	Utility class to provide units
 */
@Component
public class UnitUtil {

	
	private static String unit;
	private static Map<String, String> temperatureUnits;
	private static Map<String, String> speedUnits;
	
	@Value("${weather.api.units}")
	public void setUnit(String unit){
		UnitUtil.unit = unit;
	}
	
	@Value("#{temperatureUnits}")
	public void setTemperatureUnits(Map<String,String> temperatureUnits){
		UnitUtil.temperatureUnits = temperatureUnits;
	}
	
	@Value("#{speedUnits}")
	public void setSpeedUnits(Map<String,String> speedUnits){
		UnitUtil.speedUnits = speedUnits;
	}
	
	public static String getTemperatureUnit(){
		return temperatureUnits.get(unit);
	}
	public static String getSpeedUnit(){
		return speedUnits.get(unit);
	}
}
