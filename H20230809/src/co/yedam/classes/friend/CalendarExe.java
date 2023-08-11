package co.yedam.classes.friend;

//import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
//		Calendar cal = Calendar.getInstance();//인스턴스 만드는 메소드
//		
//		System.out.println(cal.get(Calendar.YEAR));//호출되는 시점의 년도를 보여줌
//		System.out.println(cal.get(Calendar.MONTH));//상수값에 해당되는 값을 반환, 달은 0부터 시작
//		System.out.println(cal.get(Calendar.DATE));
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK));//요일은 일요일이 1
//		System.out.println(cal.get(7));
//		System.out.println(Calendar.YEAR);//1로 출력 1이 뭔지 모르니 cal.get메소드 사용
//		
//		cal.set(2023, 0, 1);//1월1일로 세팅
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); //1월1일의 요일
//		System.out.println(cal.getActualMaximum(Calendar.DATE));//해당월의 마지막날짜
//		
//		//1일이 무슨요일, 해당 월이 며칠까지 있는지
		CalendarApp app = new CalendarApp();
		app.showCalendar(2023,5);
	}
}
