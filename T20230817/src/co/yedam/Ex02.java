package co.yedam;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("첫번째 정수 입력>> ");
		int num1 = Integer.parseInt(scn.nextLine());
		System.out.print("두번째 정수 입력>> ");
		int num2 = Integer.parseInt(scn.nextLine());
		
		int sum2 = 0;
		int sum3 = 0;
		if(num1 > num2) {
			for(int i=num2; i<=num1; i++) {
				if(i%2 == 0) {
					sum2 += i;
				}
				if(i%3 == 0) {
					sum3 += i;
				}
			}
		}else if(num1 < num2) {
			for(int i=num1; i<=num2; i++) {
				if(i%2 == 0) {
					sum2 += i;
				}
				if(i%3 == 0) {
					sum3 += i;
				}
			}
		}
		System.out.printf("2의 배수의 합: %d, 3의 배수의 합: %d", sum2, sum3);
	}
}
