package co.yedam.classes.board;

import java.util.Scanner;

public class BoardApp {
	Scanner scn = new Scanner(System.in);
	Board[] boards = new Board[10];
	boolean isExist = false;
	//생성자
	BoardApp(){}
	//프린트 메소드
	String printString(String msg) {
		System.out.print(msg+">> ");
		return scn.nextLine();
	}
	int printNumber(String msg) {
		System.out.print(msg+">> ");
		return Integer.parseInt(scn.nextLine());
	}
	
	//기능 메소드
	void addBoard() {
		Board board = new Board();
		System.out.print("제목>> ");
		board.setBorTit(scn.nextLine());
		System.out.print("내용>> ");
		board.setBorCon(scn.nextLine());
		System.out.print("작성자>> ");
		board.setBorWri(scn.nextLine());
		for(int i=0; i<boards.length; i++) {
			if(boards[i] == null) {
				board.setBorNo(i+1);
				boards[i] = board;
				break;
			}
		}
	}//end of addBoard
	
	void listBoard() {
		System.out.printf("글번호\t제목\t\t작성자\n");
		for(int i=0; i<boards.length; i++) {
			if(boards[i] != null) {
				System.out.printf("\t%s\t%4s\t%6s\n",boards[i].getBorNo(), boards[i].getBorTit(), boards[i].getBorWri());
			}
		}
	}//end of listBoard
	
	void findBoard() {
		BoardApp app = new BoardApp();
		int num = app.printNumber("글번호");
		for(int i=0; i<boards.length; i++) {
			if(boards[i] != null && boards[i].getBorNo() == num) {
				System.out.printf("글번호: %s        작성자: %s\n글내용: %s\n",
						boards[i].getBorNo(),boards[i].getBorWri(),boards[i].getBorCon());
				isExist = true;
				break;
			}
		}
		if(!isExist) { System.out.println("입력한 글번호가 없습니다.");}
	}//end of findBoard
	
	void editBoard() {
		BoardApp app = new BoardApp();
		int num = app.printNumber("글번호");
		String newTit = app.printString("제목");
		String newCon = app.printString("글내용");
		for(int i=0; i<boards.length; i++) {
			if(boards[i] != null && boards[i].getBorNo() == num) {
				boards[i].setBorTit(newTit);
				boards[i].setBorCon(newCon);
				isExist = true;
				break;
			}
		}
		if(!isExist) {System.out.println("입력한 글번호가 없습니다.");}
	}//end of editBoard
	
	void delBoard() {
		BoardApp app = new BoardApp();
		int num = app.printNumber("글번호");
		for(int i = 0; i < boards.length-1; i++) {
			for(int j=0; j< boards.length-1; j++) {
				Board tmp = new Board();
				if(boards[j] != null &&
				   boards[j+1] != null &&
				   boards[j].getBorNo() > boards[j+1].getBorNo()) {
					tmp = boards[j];
					boards[j] = boards[j+1];
					boards[j+1] = tmp;
				}
			}
		}
		for(int i=0; i<boards.length; i++) {
			if(boards[i] != null && boards[i].getBorNo() == num) {
				boards[i] = null;
				System.out.println("글이 삭제되었습니다!");
				isExist = true;
				break;
			}
		}
		if(!isExist) {System.out.println("입력한 글번호가 없습니다.");}
	}//end of delBoard
	
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
				app.listBoard();
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
				System.out.println("종료합니다");
				run = false;
			}
		}
		System.out.println("종료되었습니다.");
	}//end of start
}
