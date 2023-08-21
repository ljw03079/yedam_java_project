package co.yedam.generic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExe {
	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//MM:월, mm:분
		System.out.println(today.toString());//현재 날짜 및 시간
		System.out.println(sdf.format(today));//Date -> String
		
		String strTime = "2023-09-01 13:22:33";//문자열, 형식 맞춰줘야함
		try {
			Date newdate = sdf.parse(strTime);//String -> Date
			System.out.println(newdate.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
