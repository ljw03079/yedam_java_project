package co.yedam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BoardMain {
	public static void main(String[] args) {
		List<Board> boardList = new ArrayList<>();
		BoardApp app = new BoardApp();
		boolean run = true;
		
		//start
		while(run) {
			System.out.println("===================================");
			System.out.println("1.추가 2.수정 3.조회 4.삭제 5.목록 9.종료");
			System.out.println("===================================");
			int menu = Integer.parseInt(app.printString("선택"));
			
			switch(menu) {
			case 1:
				app.register();
				break;
			case 2:
				app.modify();
				break;
			case 3:
				app.search();
				break;
			case 4:
				app.remove();
				break;
			case 5:
				app.list();
				break;
			case 9:
				System.out.println("종료합니다.");
				app.save();
				run = false;
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}
	}
}
