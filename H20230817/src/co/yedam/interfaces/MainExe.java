package co.yedam.interfaces;

import java.util.Scanner;

public class MainExe {
	public static void main(String[] args) {
		Dao dao = new OracleDao(); //구현클래스 활용해서 인터페이스 사용, 인터페이스 변수에 인스턴스 할당(구현클래스 대입):자동 형변환, 구현클래스 변경시 나머지 기능 코드 변경없이 사용가능, 인터페이스는 하나의 데이터타입
		String str;
		Scanner scn = new Scanner(System.in);
		boolean run = true; 
		int menu = -1;
		while (run) {
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.print("선택>> ");
			menu = scn.nextInt();
			scn.nextLine();

			switch (menu) {
			case 1:
				dao.insert();
				break;
			case 2:
				dao.select();
				break;
			case 3:
				dao.update();
				break;
			case 4:
				dao.delete();
				break;
			case 5:
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}
	}//end of main
}//end of class
