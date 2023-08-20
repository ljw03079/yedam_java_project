package co.yedam.api;

import java.util.Scanner;

public class StringUtils {
	static String getFileName(String filePath) {
		int idx = filePath.lastIndexOf("/");
		String fileName = filePath.substring(idx+1);
		return fileName;
	}
	
	static String checkGender(String ssn) {
		//주민번호 구분해서 남자, 여자, 오류(2000년이전: 1/2, 2000년이후: 3/4) 케이스 판별
		int birthY = Integer.parseInt(ssn.substring(0,2));
		String gender = null;
		int space = ssn.indexOf(" ");
		int hypen = ssn.indexOf("-");
		if(hypen == -1 && space == -1) {
			gender = ssn.substring(6,7);
		}else {
			gender = ssn.substring(7,8);
		}
		if(birthY < 24) {
			switch(gender) {
			case "3":
				gender = "남자";
				break;
			case "4":
				gender = "여자";
				break;
			default: 
				gender = "잘못된 값1";
			}
		} else {
			switch(gender) {
			case "1":
				gender = "남자";
				break;
			case "2":
				gender = "여자";
				break;
			default: 
				gender = "잘못된 값2";
			}
		}
		return gender;
	}
//공백, 하이픈 제거후 코드 다시 작성, 주민번호 13자리 입력

static String checkGenderTwo() {
	Scanner sc = new Scanner(System.in);
	boolean run = true;
	String gender = null;
	int birthY = 0;
	
	while(run) {
		System.out.print("주민번호 입력>>");
		String ssn = sc.nextLine();
		ssn.replace(" ", "");
		ssn.replace("-", "");
		if(ssn.length()==13) {
			gender = ssn.substring(6,7);
			birthY = Integer.parseInt(ssn.substring(0,2));
			run = false;
		}
		System.out.println("주민번호 13자리를 입력해주세요.");
	}

	if(birthY < 24) {
		switch(gender) {
		case "3":
			gender = "남자";
			break;
		case "4":
			gender = "여자";
			break;
		default: 
			gender = "잘못된 값1";
		}
	} else {
		switch(gender) {
		case "1":
			gender = "남자";
			break;
		case "2":
			gender = "여자";
			break;
		default: 
			gender = "잘못된 값2";
		}
	}
	return gender;
	}
}