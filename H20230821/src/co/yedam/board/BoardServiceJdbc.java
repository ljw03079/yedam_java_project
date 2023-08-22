package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceJdbc implements BoardService{

	//Connection 객체 (DB연결)
	//PreparedStatement 객체 (SQL쿼리 실행)
	//ResultSet 객체 (실행결과 잠시 담기)
	//String 쿼리 (쿼리 담기)
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;
	//자바 SQL에 있는 객체
	
	@Override
	public boolean add(Board board) {
		return false;
	}

	@Override
	public List<Board> list(int page) {
		List<Board> list = new ArrayList<Board>();
		
		conn = Dao.conn(); //DB연결
		query = "select * from board";
		try {
			psmt = conn.prepareStatement(query);//쿼리 처리 후 결과 담고
			rs = psmt.executeQuery();//결과 가져옴, 여러건 담김
			while(rs.next()) {//담긴 수만큼 루프
				//rs -> list 변환
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));//테이블 칼럼이름
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdContent(rs.getString("brd_content"));
				board.setBrdWriter(rs.getString("brd_writer"));
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotal() {
		return 0;
	}

	@Override
	public boolean modify(Board board) {
		query = "update board set brd_content = 'aaa' where brd_content ="+board.getBrdContent();
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean remove(int brdNo) {
		query = "delete from board where brd_no = "+brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate();//insert, update, delete를 실행할 때 사용하는 메소드, r: 처리한 건수
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Board search(int brdNo) {
		query = "select * from board where brd_no = "+brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery(); //select를 실행할 때 사용하는 메소드
			if(rs.next()) {
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdContent(rs.getString("brd_content"));
				board.setBrdWriter(rs.getString("brd_writer"));
				board.setWriteDate(rs.getDate("write_date"));
				return board;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save() {
		
	}
	
}
