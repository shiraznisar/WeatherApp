package com.weatherapp.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shiraz
 *	
 *	Utility class for date time conversion and related operations
 */
public class DateTimeUtil {
	
	private static DateFormat df = new SimpleDateFormat("EEEE hh:mm a");

	public static String unixTimeToString(long unixTime){
		Date date = new Date(unixTime * 1000);
		return df.format(date);
	}
}
