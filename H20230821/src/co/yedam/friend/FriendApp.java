package co.yedam.friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FriendApp {
	Scanner scn = new Scanner(System.in);
	// 추가, 수정, 삭제, 목록:
	Map<String, String> userList = new HashMap<>();
	List<Friend> friends = new ArrayList<Friend>();

	// 생성자
	public FriendApp() {
		userList.put("user1", "1234");
		userList.put("user2", "5678");
		userList.put("user3", "9087");
	}

	// id, pw 맞으면 기능 수행, 그게 아니면 id, pw 틀렸다고 출력 후 맞을때까지 반복
	private boolean userCheck() {
		boolean run = true;
		System.out.print("id>> ");
		String idCheck = scn.nextLine();
		System.out.print("pw>> ");
		String pwCheck = scn.nextLine();
		if (userList.containsKey(idCheck)) {
			if(userList.get(idCheck).equals(pwCheck)) {
				return true;				
			}
		}
		return false;
	}

	public void start() {
		boolean run = true;

		while (true) {
			if (userCheck()) {
				break;
			}
			System.out.println("로그인 실패");
		}
		while (run) {
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.print("선택>> ");
			int menu = -1;
			try {
				menu = scn.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("메뉴를 다시 입력하세요.");
				continue;
			} finally {
				scn.nextLine();
			}

			switch (menu) {
			case 1:
				add();
				break;
			case 2:
				edit();
				break;
			case 3:
				del();
				break;
			case 4:
				list();
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

	private void add() {
		System.out.print("이름>> ");
		String name = scn.nextLine();
		System.out.print("연락처>> ");
		String phone = scn.nextLine();
		System.out.print("생년월일 ex)1998-08-05 >> ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// yyMMdd
		String strBirth = scn.nextLine();
		Date birth = new Date();
		try {
			birth = sdf.parse(strBirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		friends.add(new Friend(name, phone, birth));
	}

	private void edit() {
		System.out.print("이름>> ");
		String name = scn.nextLine();
		System.out.print("수정할 연락처>> ");
		String phone = scn.nextLine();

		for (Friend fri : friends) {
			if (fri.getName().equals(name)) {
				fri.setPhone(phone);
				break;
			}
		}
	}

	private void del() {
		System.out.print("이름>> ");
		String name = scn.nextLine();

		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).getName().equals(name)) {
				friends.remove(i);// friends[i] = null; -> 배열일 때
				break;
			}
		}
	}

	private void list() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		for (int i = 0; i < friends.size(); i++) {
			System.out.printf("이름: %s, 연락처: %s, 생년월일: %s\n", friends.get(i).getName(), friends.get(i).getPhone(),
					sdf.format(friends.get(i).getBirth()));
		}

//		for(Friend fri : friends) {
//			System.out.println(fri);//오버라이딩 안하면 주소값 반환
//		}
	}
}
