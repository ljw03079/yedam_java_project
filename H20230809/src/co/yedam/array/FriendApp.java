package co.yedam.array;

import java.util.Scanner;

public class FriendApp {
	static Friend[] friends = new Friend[10]; //checkFriend에서도 main에서도 쓰일 수 있음
	static Scanner scn = new Scanner(System.in);
	static String name;
	static String phone;
	static Gender gender;
	
	//checkFriend/ main 메소드가 있는 클래스이면 앞에 public static을 붙임
	public static boolean checkFriend(String name) {
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && friends[i].name.equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public static void init() {
		//초기값
				for(int i=0; i<5; i++) {
					Friend f = new Friend();
					f.name = "test"+i;
					f.phone = "010-3245-456"+i;
					f.gender = i%2 == 0 ? Gender.MEN : Gender.WOMEN;
					
					friends[i] = f;
				}
	}
	
	public static void printMenu() {
		System.out.println("----------------------------------");
		System.out.println("1.추가 2.수정 3.삭제 4.조회 5.목록 6.종료");
		System.out.println("----------------------------------");
		System.out.print("선택>>");
	}
	
	public static void add() {
		System.out.println("이름>>");
		name = scn.nextLine();
		System.out.println("연락처>>");
		phone = scn.nextLine();
		System.out.println("성별(1:남자, 2:여자)>>");
		gender = null;
		int choice = Integer.parseInt(scn.nextLine());
		if(choice == 1) {
			gender = Gender.MEN;
		}else {
			gender = Gender.WOMEN;
		}
		Friend fnd = new Friend();
		fnd.name = name;
		fnd.phone = phone;
		fnd.gender = gender;
		boolean isExist = false;
		for(int i=0; i<friends.length; i++) {
			if(friends[i] == null) {
				friends[i] = fnd;
				isExist = true;
				break;
			}
		}
		if(!isExist){
			System.out.println("더이상 입력할 수 없습니다.");
		}else {
			System.out.println("정상적으로 등록되었습니다.");					
		}
	}
	
	public static void edit() {
		System.out.println("이름>>");
		name = scn.nextLine();
		if(!checkFriend(name)) {
			System.out.println("찾는 이름이 없습니다.");
			return; //메소드의 실행을 정지
		}
		System.out.println("연락처>>");
		String phone = scn.nextLine();
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null) {
				if(name.equals(friends[i].name)) {
					friends[i].phone = phone;
					break; //for
				}
			}
		}
	}
	
	public static void del() {
		System.out.println("이름>>");
		name = scn.nextLine();
		if(!checkFriend(name)) {
			System.out.println("찾는 이름이 없습니다.");
			return;
		}
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && friends[i].name.equals(name)) {
				friends[i] = null; //삭제
				break;
			}
		}
	}
	
	public static void search() {
		System.out.println("이름>>");
		name = scn.nextLine();
		if(!checkFriend(name)) {
			System.out.println("찾는 이름이 없습니다.");
			return;
		}
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && friends[i].name.equals(name)) {
				friends[i].showInfo();
			}
		}
	}
	
	public static void list() {
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null) {
				friends[i].briefInfo();
			}
		}
	}
	
	public static void main(String[] args) {
		init();
		//추가, 수정, 삭제, 조회, 목록, 종료
		boolean run = true;
		
		while(run) {
			printMenu();
			
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu){
			case 1: 
				add(); break;
			case 2:
				edit(); break; //switch
			case 3:
				del(); break;
			case 4: //이름,연락처,성별
				search(); break;
			case 5: //이름,연락처,성별
				list(); break;
			case 6: System.out.println("종료합니다."); run=false; break;
			default: System.out.println("메뉴를 다시 선택하세요");
			}
		}
		System.out.println("프로그램 종료");
	}
}
