package co.yedam.variable;

import java.util.Scanner;

/*Scanner 클래스 활용*/
public class VariableExe5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //스캐너(키보드 입력)
		
		String numStr = "123";
		int num = Integer.parseInt(numStr); // "123" -> 123 변환
		System.out.println(num);
		
		int sum = 0;
		
		while(true) {
			System.out.println("정수값을 입력: 종료하려면 quit >>>");
			String result = scan.nextLine(); //입력값을 문자열로 반환.
			System.out.printf("입력값은 %s입니다 \n", result);
			if(result.equals("quit")) {
				break;
			}
			//입력값이 100보다 크거나 0보다 작으면 합계 안하고 범위안의 값만 합하도록..
			int val = Integer.parseInt(result);
			if(val > 100 || val < 0) { //조건을 만족못하면 다시 처리
				continue; //아래 코드 실행하지 않고 반복문 시작부분으로 올라감
			}
			sum += val;
			}
		System.out.println("입력값의 합계는 "+sum);
		System.out.println("end of prog.");
	}
} 
