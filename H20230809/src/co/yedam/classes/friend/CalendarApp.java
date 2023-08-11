package co.yedam.classes.friend;

import java.util.Calendar;

public class CalendarApp {
	public void showCalendar(int year, int month) {
		// 달력출력
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };

		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1,1);
		int space = cal.get(Calendar.DAY_OF_WEEK)-1;//1일의 정보를 가져옴
		int lastDate = cal.getActualMaximum(Calendar.DATE);

		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s",days[i]);
		}
		System.out.println();
		for(int i=0; i<space-1; i++) {
			System.out.printf("%4s"," ");
		}
		for(int i=1; i<=lastDate; i++) {
			System.out.printf("%4d",i+1);
			if((i+space)%7 == 0) {
				System.out.println();
			}
		}

	}
}
