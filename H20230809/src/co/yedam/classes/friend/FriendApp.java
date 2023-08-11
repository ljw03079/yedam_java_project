package co.yedam.classes.friend;

import java.text.ParseException;//같은 패키지 내 동일 적용
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FriendApp {
	//필드
	//접근지시자(access modifier)
	//default : 기본 접근 가능(앞에 아무것도 안붙임), 다른 클래스에서 호출 가능, 다른 패키지에서는 호출 불가
	//public : 어떤 패키지이던 접근 가능, private: 같은 클래스 외 외부에서 접근못하도록 함
	private Scanner scn = new Scanner(System.in);
	private Friend[] friends = new Friend[10];//데이터를 담기위해 배열 선언
	//생성자
	FriendApp() {
		
	}
	
	void addFriend() {
		System.out.print("이름 연락처 생년월일>> ");
		String[] data = scn.nextLine().split(" ");
//		//입력: 950304 -> date 타입으로 인식하게끔
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		//SimpleDateFormat: 이 형식으로 입력되면 해당 년,월,일로 인식해서 타입을 date로 바꿔주는 클래스
//		Date birth = null; //String -> Date
//		try {
//			birth = sdf.parse(data[2]); //parse메소드를 이용하면 date타입으로 바꿔줌
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		Friend friend = new Friend(data[0], data[1], data[2]); // 인스턴스 생성

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}
	}// addFriend끝
	
	final int num = 0; //다시 값을 바꿀 수 없음, 상수역할
	//num = 1; //에러

	void list() {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.println(friends[i].toString());
			}
		}
	}
	
	void findFriend() {
		String name = printString("조회할 친구의 이름을 입력하세요.");
		boolean a = false;
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] != null && friends[i].getName().equals(name)) {
				System.out.println(friends[i].toString());
				a = true;
				break;
			}
		}
		if(!a) {
			System.out.println("입력한 이름의 데이터가 없습니다.");
		}
	}
	
	void editFriend() {
		System.out.println("수정할 친구의 이름을 입력하세요.");
		String name = scn.nextLine();
		System.out.print("수정할 연락처>> ");
		String phone = scn.nextLine();
		boolean a = false;
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] != null && friends[i].getName().equals(name)) {
				friends[i].setPhone(phone);
				a = true;
				break;
			}
		}
		if(!a) {
			System.out.println("입력한 이름의 데이터가 없습니다.");
		}
	}
	
	void delFriend() {
		System.out.println("삭제할 친구의 이름을 입력하세요.");
		String name = scn.nextLine();
		boolean a = false;
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] != null && friends[i].getName().equals(name)) {
				friends[i]=null;
				a = true;
				break;
			}
		}
		if(!a) {
			System.out.println("입력한 이름의 데이터가 없습니다.");
		}
	}
	
	String printString(String msg) {
		System.out.println(msg+">>");
		return scn.nextLine();
	}
	int printNumber(String msg) {
		System.out.println(msg + ">>");
		return Integer.parseInt(scn.nextLine());
	}
	
	/*static*/ void start() {

		FriendApp app = new FriendApp();
		//Scanner scn = app.scn;
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.조회(이름) 4.수정 5.삭제 9.종료");
			System.out.println("선택>> "); //findFriend/ editFriend/ delFriend

			int menu = app.printNumber("선택");
			//int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case Menu.ADD:
				app.addFriend();
				break;
			case Menu.LIST:
				app.list();
				break;
			case Menu.SEARCH:
				app.findFriend();
				break;
			case Menu.EDIT:
				app.editFriend();
				break;
			case Menu.DEL:
				app.delFriend();
				break;
			case Menu.EXIT:
				app.printString("종료합니다.");
				run = false;
			}//end of switch
		}//end of while
	}//end of start
}//end of class
