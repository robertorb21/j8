package robert.rodriguez;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class WidthDates {

	public static void main(String[] args) throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		System.out.println(calendar.getTime());
		
		
		String myDate = "2019-06-12 12:24:15";
	    Date date1 = new SimpleDateFormat("yyyyMMdd").parse(myDate);  
	    System.out.println(date1);
	    
	    Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(myDate);
	    System.out.println(date2);
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyMMdd");
	    System.out.println(formatter.format(date2));
	    
	    
	    System.out.println(new Date());
	    
	    
	    LocalDate todaydate = LocalDate.now();
		System.out.println("Months first date in yyyy-mm-dd: " +todaydate.withDayOfMonth(1));
	    
	    
	    Calendar c = Calendar.getInstance();   // this takes current date
	    c.set(Calendar.DAY_OF_MONTH, 1);
	    System.out.println(c.getTime()); 
	    
	    
	    // 20 de febrero
	    // Exception pues no tiene 30 dias
	    // 1ro de marzo 
	    // 02 de marzo
	    Calendar febrero = Calendar.getInstance();
	    febrero.set(Calendar.YEAR, 2020);
	    febrero.set(Calendar.MONTH, Calendar.FEBRUARY);
	    febrero.set(Calendar.DATE, 30);
	    System.out.println(febrero.getTime());
	}
}
