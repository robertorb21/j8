package robert.rodriguez.hash;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeExample {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

	public static void main(String[] args) {

		// method 1
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		System.out.println(timestamp);

		// method 2 - via Date
		Date date = new Date();
//		System.out.println(new Timestamp(date.getTime()));

		// return number of milliseconds since January 1, 1970, 00:00:00 GMT
		System.out.println(timestamp.getTime());
		Timestamp ts = new Timestamp(new Date().getTime());
//		System.out.println("Current Time Stamp: " + ts);

		// format timestamp
//		System.out.println(sdf.format(timestamp));
		
		System.out.println("+===========================+");
		long now = System.currentTimeMillis();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 4);
//		System.out.println("---->  "+cal.getTime());
		cal.set(Calendar.HOUR, 16);
//		System.out.println("---->  "+cal.getTime());
		long timeToExceoute = cal.getTimeInMillis();

		System.out.println("+===========================+");
		Calendar cale = Calendar.getInstance();
		cale.add(Calendar.DATE, 1);
		cale.set(Calendar.HOUR_OF_DAY, 4);
		cale.set(Calendar.MINUTE, 0);
		cale.set(Calendar.SECOND, 0);
		cale.set(Calendar.MILLISECOND, 0);
		System.out.println("----> "+now);
		System.out.println("----> "+cale.getTime());
		
		if (now<= cale.getTimeInMillis()) {
			System.out.println("Vigente");
		} else {
			System.out.println("regeneramos");
		}
	}
}
