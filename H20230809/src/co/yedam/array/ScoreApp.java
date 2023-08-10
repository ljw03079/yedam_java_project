package co.yedam.array;

import java.util.Scanner;

class Member {
	String name;
	int score;
}
//ctl + shift + f => 코드 정렬하기

public class ScoreApp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int[] scores = null;
		String[] data = null;

//		String[] data = scn.nextLine().split(" "); // hong 88
//		System.out.println(data[0]); // hong
//		System.out.println(data[1]); // 88
//		System.out.println("----------");
//		for (String elem : data) {
//			System.out.println(elem);
//		} // 배열 반복문

		while (run) {
			System.out.println("--------------------------------------------------");
			System.out.println("1.학생수 | 2.이름과 점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------------");
			System.out.print("선택>");

			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				System.out.print("학생수>");
				int stuNum = Integer.parseInt(scn.nextLine())*2;
				data = new String[stuNum];
				break;
			case 2:
				for(int i=0; i<data.length; i += 2) {
					System.out.print("이름 점수>");
					data = scn.nextLine().split(" ");
					System.out.printf("이름: %s, 점수: %s\n", data[i], data[i+1]);
				}
				break;
			case 3:
				System.out.print("점수리스트>");
				for(String elem : data) {
					System.out.printf(elem);
				}
				break;
			case 4:
				int maxData = Integer.parseInt(data[1]);
				int sumData = 0;
				for(int i=0; i<data.length; i += 2) {
					if(i%2 != 0) {
						if(maxData < Integer.parseInt(data[i])){
							maxData = Integer.parseInt(data[i]);
						}
						sumData += Integer.parseInt(data[i]);
					} 
				}
				double avgData = (double) sumData/data.length*2;
				System.out.printf("최고 점수: ",maxData);
				System.out.printf("평균 점수: ",avgData);
				break;
			case 5:
				run=false;
			}
		}
		System.out.println("시스템 종료");

//		while (run) {
//			System.out.println("---------------------------------------------");
//			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
//			System.out.println("---------------------------------------------");
//			System.out.print("선택>");
//
//			int menu = Integer.parseInt(scn.nextLine());
//			switch (menu) {
//			case 1:
//				System.out.print("학생수>");
//				int stuNum = Integer.parseInt(scn.nextLine());
//				scores = new int[stuNum];
//				break;
//			case 2:
//				for (int i = 0; i < scores.length; i++) {
//					System.out.print("점수입력>");
//					int stuSco = Integer.parseInt(scn.nextLine());
//					scores[i] = stuSco;
//					System.out.printf("scores[%d]> %d\n", i, scores[i]);
//				}
//				break;
//			case 3:
//				System.out.println("점수리스트>");
//				for (int i = 0; i < scores.length; i++) {
//					System.out.printf("scores[%d]> %d\n", i, scores[i]);
//				}
//				break;
//			case 4:
//				int maxSco = scores[0];
//				int sumSco = 0;
//				for (int i = 0; i < scores.length; i++) {
//					if (maxSco < scores[i]) {
//						maxSco = scores[i];
//					}
//					sumSco += scores[i];
//				}
//				double avgSco = (double) sumSco / scores.length;
//				System.out.printf("최고 점수: %d\n", maxSco);
//				System.out.printf("평균 점수: %f\n", avgSco);
//				break;
//			case 5:
//				run = false;
//			}
//		}
//		System.out.println("시스템 종료하였습니다.");
	}
}
