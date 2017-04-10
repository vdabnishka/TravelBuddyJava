package com.tek.travelbuddy.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	public static String getDateText(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_PATTERN);
		return format.format(date);
	}
	
	public static Date parseDate(String dateText) {
		SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_PATTERN);

		Date date;
		
		try {
			date = format.parse(dateText);
		}
		catch (ParseException e) {
			date = null;
		}
		
		return date;
	}
}
