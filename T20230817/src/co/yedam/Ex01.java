package co.yedam;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("첫번째 정수 입력>> ");
		int num1 = Integer.parseInt(scn.nextLine());
		System.out.print("두번째 정수 입력>> ");
		int num2 = Integer.parseInt(scn.nextLine());
		
		if(num1 > num2) {
			System.out.printf("큰 수: %d", num1);
		}else if(num1 < num2){
			System.out.printf("큰 수: %d", num2);
		}
	}
}
