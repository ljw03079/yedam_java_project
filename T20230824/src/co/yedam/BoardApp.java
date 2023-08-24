package co.yedam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BoardApp{
	Scanner scn = new Scanner(System.in);
	List<Board> boardList = new ArrayList<>();
	
	public BoardApp(){
		init();
	}
	
	private void init() {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/boardList.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			boardList = (List<Board>) ois.readObject();
			
			ois.close();
			fis.close();
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/boardList.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(boardList);
			
			oos.flush(); oos.close();
			fos.flush(); fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getMaxNo() {
		int brdNo = 0;
		for(int i=0; i<boardList.size(); i++) {
			if(boardList.get(i).getBrdNo() > brdNo) {
				brdNo = boardList.get(i).getBrdNo();
			}
		}
		return brdNo + 1;
	}
	
	public void register() {
		int brdNo = getMaxNo();
		String brdTitle = printString("제목입력");
		String brdContent = printString("내용입력");
		String brdWriter = printString("작성자입력");
		Date date = new Date();
		Date brdWriteDate = date;
		Board board = new Board(brdNo, brdTitle, brdContent, brdWriter, brdWriteDate);
		
		boardList.add(board);
		System.out.println("---등록되었습니다.---");
	}//end of registar
	
	public void modify() {
		int brdNo = Integer.parseInt(printString("글번호 입력"));
		for(int i=0; i<boardList.size(); i++) {
			if(boardList.get(i).getBrdNo() == brdNo) {
				String brdContent = printString("수정할 내용 입력");
				boardList.get(i).setBrdContent(brdContent);
				return;
			}
		}
		System.out.println("입력한 글번호가 없습니다.");
	}//end of registar
	
	public void search() {
		int brdNo = Integer.parseInt(printString("글번호 입력"));
		for(int i=0; i<boardList.size(); i++) {
			if(boardList.get(i).getBrdNo() == brdNo) {
				System.out.println(boardList.get(i).toString());
				return;
			}
		}
		System.out.println("입력한 글번호가 없습니다.");
	}//end of search
	
	public void remove() {
		int brdNo = Integer.parseInt(printString("글번호 입력"));
		for(int i=0; i<boardList.size(); i++) {
			if(boardList.get(i).getBrdNo() == brdNo) {
				boardList.remove(i);
				System.out.println("---삭제되었습니다.---");
				return;
			}
		}
		System.out.println("입력한 글번호가 없습니다.");
	}//end of remove
	
	public void list() {
		for(int i=0; i<boardList.size(); i++) {
			System.out.println(boardList.get(i).toString());
			System.out.println("-----------------------------------");
		}
	}//end of list
	
	public String printString(String msg) {
		System.out.print(msg+">> ");
		return scn.nextLine();
	}
}
