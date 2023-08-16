package co.yedam.classes.board;

import java.util.Scanner;

public class BoardApp {
	private Scanner scn = new Scanner(System.in);
	private Board[] boards = new Board[10];
	
	BoardApp(){}
	
	void addBoard() {
		Board board = new Board();
		System.out.print("제목>> ");
		board.setBorTitle(scn.nextLine());
		System.out.print("내용>> ");
		board.setBorContent(scn.nextLine());
		System.out.print("작성자>> ");
		board.setBorWriter(scn.nextLine());
		for(int i=0; i<boards.length; i++) {
			if(boards[i] == null) {
				board.setBorNo(i+1);
				boards[i] = board;
				break;
			}
		}
	}
	
	void list() {
		System.out.printf( "글번호 \t 제목 \t 작성자\n");
		for(int i=0; i<boards.length; i++) {
				if(boards[i] != null) {
					System.out.println(boards[i].toString());
				}
		}
	}
	
	void findBoard() {
		boolean ck = false;
		System.out.print("글번호>> ");
		int num = Integer.parseInt(scn.nextLine());
		for(int i=0; i<boards.length; i++) {
			if(boards[i] != null && boards[i].getBorNo() == num) {
				System.out.printf("글번호: %d, 작성자: %s, 글내용: %s\n",
						boards[i].getBorNo(), boards[i].getBorWriter(), boards[i].getBorContent() );
				ck = true;
				break;
			}
		}
		if(!ck) {
			System.out.println("입력한 글번호가 없습니다.");
		}
	}
	
	void editBoard() {
		boolean ck = false;
		System.out.print("글번호>> ");
		int num = Integer.parseInt(scn.nextLine());
		System.out.print("제목>> ");
		String cgTitle = scn.nextLine();
		System.out.print("글내용>> ");
		String cgContent = scn.nextLine();
		for(int i=0; i<boards.length; i++) {
			if(boards[i] != null && boards[i].getBorNo() == num) {
				boards[i].setBorTitle(cgTitle);
				boards[i].setBorContent(cgContent);
				ck = true;
				break;
			}
		}
		if( !ck ) {
			System.out.println("입력한 글번호가 없습니다.");
		}
	}
	
	void delBoard() {
		boolean ck = false;
		System.out.print("글번호>> ");
		int num = Integer.parseInt(scn.nextLine());
		System.out.println("글이 삭제되었습니다!!");
		for(int j=0; j<boards.length-1; j++) {
			for(int i=0; i<boards.length-1; i++) {
				Board tmp = new Board();
				if(boards[i].getBorNo() > boards[i+1].getBorNo()) {
					tmp = boards[i];
					boards[i] = boards[i+1];
					boards[i+1] = tmp;
				}
			}
		}
		for(int i=0; i<boards.length; i++) {
			if(boards[i] != null && boards[i].getBorNo() == num) {
				boards[i] = null;
				ck = true;
				break;
			}
		}
		if( !ck ) {
			System.out.println("입력한 글번호가 없습니다.");
		}
	}
	String printString(String msg) {
		System.out.print(msg+">> ");
		return scn.nextLine();
	}
	int printNumber(String msg) {
		System.out.print(msg+">> ");
		return Integer.parseInt(scn.nextLine());
	}
	
	void start() {
		BoardApp app = new BoardApp();
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.상세보기 4.수정 5.삭제 9.종료");
			int menu = app.printNumber("선택");
			
			switch(menu) {
			case Menu.ADD:
				app.addBoard();
				break;
			case Menu.LIST:
				app.list();
				break;
			case Menu.SEARCH:
				app.findBoard();
				break;
			case Menu.EDIT:
				app.editBoard();
				break;
			case Menu.DEL:
				app.delBoard();
				break;
			case Menu.EXIT:
				System.out.println("종료합니다.");
				run=false;
			}
		}
	}
}
