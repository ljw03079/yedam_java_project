package co.yedam.example;

import java.util.Scanner;

public class Example {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int studentNum = 0;
		int[] scores = null;
		int sum = 0;
		float avg = 0;
		
		while(true) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			
			System.out.println("메뉴를 입력하세요 >>>");
			int menu = Integer.parseInt(scn.nextLine());
			
			if(menu == 1) {
				System.out.println("학생수를 입력하세요");
				studentNum = Integer.parseInt(scn.nextLine());
				System.out.println("학생수 : "+studentNum);
				scores = new int[studentNum];
			}else if(menu == 2) {
				for(int i=0; i<studentNum; i++) {
					scores[i] += Integer.parseInt(scn.nextLine());
				}
			}else if(menu == 3) {
				for(int i=0; i<scores.length; i++) {
					System.out.println(scores[i]+", ");					
				}
			}else if(menu == 4) {
				int max = scores[0];
				int min = scores[0];
				for(int i=0; i<scores.length; i++) {
					if(max < scores[i]) {
						max = scores[i];
					}
					if(min > scores[i]) {
						min = scores[i];
					}
					sum += scores[i];
				}
				avg = sum/scores.length;
				System.out.println("최고 점수 : "+max);
				System.out.println("최저 점수 : "+min);
				System.out.println("평균 점수 : "+avg);
			}else if(menu == 5) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		
	}
}
