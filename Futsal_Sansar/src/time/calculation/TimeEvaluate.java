package time.calculation;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeEvaluate {

	public static boolean timeCalculate(String recentTime, String recentDur, String bookTime, String bookDur) {

		int flag = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
		Date sTime, lTime;
		try {
			sTime = sdf.parse(recentTime);
			lTime = sdf.parse(bookTime);

			long startTime = sTime.getTime() + 19800000;
			long endTime = sTime.getTime() + 19800000 + Integer.parseInt(recentDur) * 3600000;
			long startBook = lTime.getTime() + 19800000;
			long endBook = lTime.getTime() + 19800000 + Integer.parseInt(bookDur) * 3600000;

			if (startBook < startTime && endBook > startTime) {
				flag = 1;
			} else if (startBook < endTime && endBook > startTime) {
				flag = 1;
			} else {
				flag = 0;
			}

		} catch (ParseException e) {
			e.printStackTrace();

		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean timeCalculat2(String recentTime, String recentDur, String bookTime, String bookDur) {

		int flag = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
		Date sTime, lTime, hTime;
		try {
			sTime = sdf.parse(recentTime);
			lTime = sdf.parse(bookTime);
			hTime = sdf.parse(bookDur);

			long startTime = sTime.getTime() + 19800000;
			long endTime = sTime.getTime() + 19800000 + Integer.parseInt(recentDur) * 3600000;
			long startBook = lTime.getTime() + 19800000;
			long endBook = hTime.getTime() + 19800000;

			if (startBook < startTime && endBook > startTime) {
				flag = 1;
			} else if (startBook < endTime && endBook > startTime) {
				flag = 1;
			} else {
				flag = 0;
			}

		} catch (ParseException e) {
			e.printStackTrace();

		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean dateCalculate1(String recentDate, String recentDur, String bookDate, String bookDur) {

		int flag = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1, date2;
		try {
			date1 = sdf.parse(recentDate);
			date2 = sdf.parse(bookDate);
			long d1 = date1.getTime();
			long d2 = d1 + Long.parseLong(recentDur) * 86400000;
			long d3 = date2.getTime();
			long d4 = d3 + Long.parseLong(bookDur) * 86400000;
			System.out.println(d1);
			System.out.println(d2);
			System.out.println(d3);
			System.out.println(d4);

			if ((d3 < d1 && d1 < d4) || (d3 < d2 && d2 < d4)) {
				flag = 1;
			}
			if ((d1 > d3 && d2 > d3) && (d1 > d4) && d2 > d4) {
				flag = 0;
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean dateCalculate2(String recentDate, String recentDur, long lowDate, String highDate) {

		int flag = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1, date3;
		try {
			date1 = sdf.parse(recentDate);
			date3 = sdf.parse(highDate);
			long d1 = date1.getTime();
			long d2 = d1 + Long.parseLong(recentDur) * 86400000;
			long d3 = lowDate;
			long d4 = date3.getTime();
			System.out.println(d1);
			System.out.println(d2);
			System.out.println(d3);
			System.out.println(d4);
			if (d3 == d4) {
				if ((d3 < d1 && d1 < d4) || (d3 < d2 && d2 < d4))
					flag = 1;
				else
					flag = 0;
			} else if ((d3 < d1 && d1 < d4) || (d3 < d2 && d2 < d4)) {
				flag = 0;
			} else if ((d1 > d3 && d2 > d3) && (d1 > d4) && d2 > d4) {
				flag = 0;
			} else {
				flag = 1;
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String args[]) {

		long a = 30;
		long b = 86400000;
		long c = a * b;
		System.out.println(c);

	}
}
