package co.yedam.variable;

import java.io.IOException;

public class VariableExe4 {
	public static void main(String[] args) {
		//이름은 홍길동, 나이는 20살 입니다.
		String name = "홍길동";
		int age = 20;
		double weight = 67.8;
		
		System.out.println("이름은 "+name+", 나이는 "+age+"살 입니다.");
		System.out.printf("이름은 %s, \n나이는 %d살, \n몸무게는 %.2f 입니다.\n", name, age, weight);
		
		
		try {
			System.out.println("값을 입력>>>"); //a Enter
			while(true) {
				int result = System.in.read();
				if(result == 113) { //q: 113
					break;
				} else if(result == 10 || result == 13) {
					// ENTER(cr: 13, lf: 10)
				} else {
					System.out.println("키코드 : "+result);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end of prog.");
	} // end of main
} // end of class
