package demo.hibernate.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	//citesc un string date si il convertesc la date
	
	public static Date parseDate(String dateStr) throws ParseException{
		Date theDate = formatter.parse(dateStr);
		return theDate;
	}
	
	//citesc un  date si il convertesc la string
	public static String formatDate(Date theDate) {
		
		String result = null;
		if(theDate !=null) {
			result = formatter.format(theDate);
		}
		return result;
	}
	
	
}
