package co.yedam.array;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		// 1.등록 2.조회 3.목록 4.종료
		Scanner scn = new Scanner(System.in);
		Student[] students = new Student[10];
		boolean run = true;
		int idx = 0;
		
		while(run) {
			System.out.println("-----------------------");
			System.out.println("1.등록 2.조회 3.목록 4.종료");
			System.out.println("-----------------------");
			
			System.out.println("선택 >>>");
			int menu = scn.nextInt();
			switch(menu) {
			case 1: //이름, 점수 입력
				Student stu = new Student();
				System.out.println("이름 입력 >>");
				stu.name = scn.nextLine();
				//System.out.println("점수 입력 >>");
				stu.score = scn.nextInt();
				students[idx] = stu;
				idx ++;
			case 2: //이름을 넣으면 해당하는 점수 출력
				
			case 3: //이름, 점수 한번에 출력
				for(idx=0; idx<students.length; idx++) {
					System.out.printf("이름은 %s이고 성적은 %d입니다\n",students[idx].name,students[idx].score);
				}
			case 4: run=false; //종료
			}
			
		}
		System.out.println("end of program");
	}
}
