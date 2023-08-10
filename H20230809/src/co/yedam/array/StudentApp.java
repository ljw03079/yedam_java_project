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
			System.out.println("---------------------------------------");
			System.out.println("1.등록 2.조회 3.목록 4.키가 제일 큰 학생 5.종료");
			System.out.println("---------------------------------------");
			
			System.out.print("선택 >>>");
			int menu = Integer.parseInt(scn.nextLine()); //"123" -> 123, "178.9" -> 178.9: Double.parseDouble();
			switch(menu) {
			case 1: //이름, 점수 입력
				Student stu = new Student();
				System.out.print("이름 입력 >>");
				stu.name = scn.nextLine();
				System.out.print("점수 입력 >>");
				stu.score = Integer.parseInt(scn.nextLine());
				System.out.print("키 입력 >>");
				stu.height = Double.parseDouble(scn.nextLine());
				students[idx] = stu;
				idx ++;
				break;
			case 2: //이름을 넣으면 해당하는 점수 출력
				//boolean isExist = false;
				System.out.print("이름 입력 >>");
				String name = scn.nextLine();
				int a = 0;
				for(int i=0; i<idx; i++) {
					if(name.equals(students[i].name)) {
						System.out.printf("%s의 점수는 %d점, 키는 %.2f입니다.\n",students[i].name, students[i].score, students[i].height);
						a = 1;
						//isExist = true;
					}
				}
				if(a == 0) {
					System.out.println("찾는 이름이 없습니다.");					
				}
				//if(!isExist){System.out.println("찾는 이름이 없습니다.")};
				break;
			case 3: //이름, 점수 한번에 출력
				for(int i=0; i<idx; i++) { //idx대신 students.length쓰려면 if(students[i] != null)을 써줘야 함.
					if(students[i].gender == Gender.MEN) {
						System.out.printf("이름: %s, 성적: %d, 키: %.2f\n",students[i].name, students[i].score, students[i].height);						
					}
				}
				break;
			case 4: //제일 키큰 학생의 이름 반환
				double maxHeight = students[0].height;
				int idxH = 0;
				for(int i=0; i<idx; i++) {
					if(maxHeight < students[i].height) {
						maxHeight = students[i].height;
						idxH = i;
					}
				}
				System.out.printf("키가 제일 큰 학생의 키는 %.2f, 이름은 %s입니다.\n", students[idxH].height, students[idxH].name);
				break;
			case 5: run=false; //종료
			}
			
		}
		System.out.println("end of program");
	}
}
