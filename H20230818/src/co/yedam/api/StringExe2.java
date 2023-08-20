package co.yedam.api;

import java.util.Scanner;

public class StringExe2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1번
		String file = "C:/Dev/temp/flower.jpg";
		StringUtils.getFileName(file);
		System.out.println(StringUtils.getFileName(file));
		//2번
		System.out.print("주민번호 입력>>");
		String ssn = sc.nextLine();
		System.out.println(StringUtils.checkGender(ssn));
		
		System.out.println(StringUtils.checkGenderTwo());
	}
}
