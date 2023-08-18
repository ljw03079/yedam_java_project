package co.yedam.friend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FriendApp {
	Scanner scn = new Scanner(System.in);

	// 배열 > 컬랙션 > 파일 > DB
	Friend[] friends = new Friend[10];

	// 컨트롤: 사용자의 입력을 받아서 처리하기 위한 기능
	public void start() {
		boolean run = true; // 지역변수, 메소드 안에서만 유효 -> 메소드가 끝나면 메모리에서 사라짐
		int menu = -1;// 초기값
		while (run) {
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.print("선택>> ");
			try {
				menu = scn.nextInt(); // ex) 3번 입력 후 엔터 -> 엔터가 처리가 안됨, next() 또는 nextLine()이 나오면 엔터처리
			} catch (InputMismatchException e) {
				// System.out.println("메뉴를 다시 선택하세요.");
				// continue; //반복문에서 아래코드로 실행하지 않고 실행 첫부분으로 이동, switch구문에서 menu = -1에 대한 처리가 있음
			} finally {
				scn.nextLine(); // 이 코드가 없으면 엔터키를 처리하려고 계속 반복
			}

			switch (menu) {
			case 1:
				addFriend();
				break;
			case 2:
				search();
				break;
			case 3:
				modify();
				break;
			case 4:
				remove();
				break;
			case 5:
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}

		}
	}

	//
	private String printString(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}

	// 등록
	private void addFriend() {
		boolean run = true;
		int subMenu = -1;
		
		while (run) {
			System.out.println("1.학교 2.회사 3.기타");
			System.out.print("선택>> ");
			try {
				subMenu = scn.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("메뉴를 다시 선택하세요.");
				continue;
			} finally {
				scn.nextLine();
			}
			run = false;
		}
		Friend friend = null;
		String name = printString("이름입력");
		String phone = printString("연락처입력");
		if (subMenu == 1) {
			String univ = printString("학교입력");
			String major = printString("전공입력");

			friend = new UnivFriend(name, phone, univ, major);
		} else if (subMenu == 2) {
			String comp = printString("회사정보");
			String dept = printString("부서정보");

			friend = new CompFriend(name, phone, comp, dept);
		} else if (subMenu == 3){
			friend = new Friend(name, phone);
		}
		//
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}
	}// end of addFriend

	// 조회: 이름입력->해당되는 정보만 조회, 이름미입력+엔터->전체리스트 조회
	private void search() {
		boolean isExist = false;
		String name = printString("이름입력");
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].getName().equals(name)) {
				System.out.println(friends[i].showInfo());
				isExist = true;
			} else if (friends[i] != null && name.equals("")) {
				System.out.println(friends[i].showInfo());
				isExist = true;
			}
		}
		if (!isExist) {
			System.out.println("입력한 이름이 없습니다.");
		}
	}// end of search

	// 수정: 이름기준 연락처수정
	private void modify() {
		boolean isExist = false;
		String name = printString("이름입력");
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].getName().equals(name)) {
				String phone = printString("수정할 연락처 입력");
				friends[i].setPhone(phone);
				isExist = true;
				break;
			}
		}
		if (!isExist) {
			System.out.println("입력한 이름이 없습니다.");
		}
	}// end of modify

	// 삭제: 이름기준
	private void remove() {
		boolean isExist = false;
		String name = printString("이름입력");
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].getName().equals(name)) {
				friends[i] = null;
				isExist = true;
			}
		}
		if (!isExist) {
			System.out.println("입력한 이름이 없습니다.");
		}
	}// end of remove
}