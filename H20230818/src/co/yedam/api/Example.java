package co.yedam.api;

import java.io.UnsupportedEncodingException;

public class Example {
	public static void main(String[] args) {
		//charAt
		String ssn = "010624-4230123";
		char sex = ssn.charAt(7);
		switch(sex) {
		case '1':
		case '3':
			System.out.println("남자 입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자 입니다.");
			break;
		}
		
		//equals
		String strVar1 = new String("신민철");
		String strVar2 = "신민철";
		
		if(strVar1 == strVar2) {
			System.out.println("같은 객체 참조");
		}else {
			System.out.println("다른 객체 참조");
		}
		
		if(strVar1.equals(strVar2)) {
			System.out.println("같은 문자열");
		}else {
			System.out.println("다른 문자열");
		}
		
		//getBytes
		String str = "안녕하세요";
		byte[] bytes1 = str.getBytes();
		System.out.println("bytes1.length: "+bytes1.length);
		String str1 = new String(bytes1);
		System.out.println("bytes->String: "+str1);
		
		
		try {
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println("bytes2.length: "+bytes2.length);
			String str2 = new String(bytes2);
			System.out.println("bytes2->String: "+str2);
			
			byte[] bytes3 = str.getBytes("UTF-8");
			System.out.println("bytes3.length: "+bytes3.length);
			String str3 = new String(bytes3);
			System.out.println("bytes3->String: "+str3);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//indexOf
		String subject = "자바 프로그래밍";
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		if(subject.indexOf("자바") != -1) {
			System.out.println("자바랑 관련있");
		}else {
			System.out.println("자바랑 관련없");
		}
	}
}
