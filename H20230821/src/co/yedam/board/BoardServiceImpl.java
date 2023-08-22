package co.yedam.board;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardServiceImpl implements BoardService {// Impl: implement , 구현객체

	List<Board> boardList = new ArrayList<>();

	public BoardServiceImpl() {
		init();
	}

	private void init() {
		try {
			FileInputStream fis = new FileInputStream("C:/temp/board.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			boardList = (List<Board>) ois.readObject();
			ois.close();
			fis.close();

		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	private int getMaxNo() {
		int brdNo = 0;
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() > brdNo) {
				brdNo = boardList.get(i).getBrdNo();
			}
		}
		return brdNo + 1;
	}

	@Override
	public boolean add(Board board) {
		board.setBrdNo(getMaxNo());
		Date date = new Date();
		board.setWriteDate(date);
		return boardList.add(board);// 정상적으로 등록되면 true 리턴
	}

	@Override
	public List<Board> list(int page) {
		int start = (page - 1) * 5;
		int end = page * 5;
		List<Board> pageList = new ArrayList<>();
		for (int i = 0; i < boardList.size(); i++) {
			if (i >= start && i < end) {
				pageList.add(boardList.get(i));
			}
		}
		return pageList;
	}

	@Override
	public boolean modify(Board board) {
		Date date = new Date();
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == board.getBrdNo()) {
				boardList.get(i).setBrdContent(board.getBrdContent());
				boardList.get(i).setUpdateDate(date);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(int brdNo) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == brdNo) {
				boardList.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public Board search(int brdNo) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == brdNo) {
				return boardList.get(i);
			}
		}
		return null;
	}

	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/board.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(boardList);// 객체를 바이트로 저장시키는 메소드, 객체->바이트: 직렬화
			// Serializable(직렬화, 역직렬화 가능한 클래스입니다.를 알려주는 인터페이스)를 구현하는 객체여야 직렬화를 사용가능
			// board에 인터페이스 연결시켜줘야 함(ArrayList는 기본적으로 연결돼있음)
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getTotal() {
		return boardList.size();
	}
}
