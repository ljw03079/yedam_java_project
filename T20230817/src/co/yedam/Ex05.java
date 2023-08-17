package co.yedam;

import java.util.Scanner;

public class Ex05 {
	Scanner scn = new Scanner(System.in);
	Friend[] friends = new Friend[10];
	//프린트 메소드
	private String printString(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}
	private int printInt(String msg) {
		System.out.print(msg + ">> ");
		return Integer.parseInt(scn.nextLine());
	}
	//컨트롤
	public void start() {
		boolean run = true;
		int menu = -1;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.전화번호수정 4.삭제 5.종료");
			menu = printInt("선택");
			
			switch(menu) {
			case 1:
				register();
				break;
			case 2:
				list();
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
	//기능 메소드
	private void register() {
		String name = printString("이름");
		String phone = printString("전화번호");
		String birth = printString("생년월일");
		System.out.print("키>> ");
		double height = Double.parseDouble(scn.nextLine());
		Friend friend = new Friend(name, phone, birth, height);
		for(int i=0; i<friends.length; i++) {
			if(friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}
	}//end of register
	private void list() {
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null) {
				System.out.println(friends[i].showInfo());
			}
		}
	}//end of list
	private void modify() {
		boolean isExist = false;
		String name = printString("이름");
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && friends[i].getName().equals(name)) {
				String phone = printString("수정할 연락처");
				friends[i].setPhone(phone);
				isExist = true;
			}
		}
		if(!isExist) {
			System.out.println("입력한 이름이 없습니다.");
		}
	}//end of modify
	private void remove() {
		boolean isExist = false;
		String name = printString("이름");
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && friends[i].getName().equals(name)) {
				friends[i] = null;
				isExist = true;
			}
		}
		if(!isExist) {
			System.out.println("입력한 이름이 없습니다.");
		}
	}//end of remove
}
