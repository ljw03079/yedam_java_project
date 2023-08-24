package co.yedam.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.common.Dao;
import co.yedam.board.vo.Board;

public class BoardServiceJdbc implements BoardService {

	// Connection 객체 (DB연결)
	// PreparedStatement 객체 (SQL쿼리 실행)
	// ResultSet 객체 (실행결과 잠시 담기)
	// String 쿼리 (쿼리 담기)
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;
	// 자바 SQL에 있는 객체

	void disconn() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (rs != null) {
				psmt.close();
			}
			if (rs != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean add(Board board) {
		query = "insert into board (brd_no, brd_title, brd_content, brd_writer)"
				+ "values ((select nvl(max(brd_no),0)+1 from board), ?, ?, ?)";// +1: 최대번호에서 +1해야 다음 번호 입력됨, ""안에는 ; 넣으면
																				// 안됨 -> 구문오류남
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, board.getBrdTitle());
			psmt.setString(2, board.getBrdContent());
			psmt.setString(3, board.getBrdWriter());
			int r = psmt.executeUpdate();// 실행안되고 가만히 있으면 SQL에서 커밋 또는 롤백 후 자바에서 다시 실행
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();			
		}
		return false;
	}

	@Override
	public List<Board> list(int page) {
		List<Board> list = new ArrayList<Board>();

		conn = Dao.conn(); // DB연결
		query = "select * \r\n"// \r(캐리지리턴)\n: 줄바꿈, 스페이스로 대체가능
				+ "from (select rownum rn, a.*\r\n" //
				+ "      from (select * from board\r\n" //
				+ "            order by brd_no) a\r\n" //
				+ "      where rownum <= (? * 5)) b\r\n" // -> 정렬할때 틀어질 수도 있어서 넣음
				+ "where b.rn > (?-1)*5";// sql, 세미콜론 넣지말기
		try {
			psmt = conn.prepareStatement(query);// 쿼리 처리 후 결과 담고
			psmt.setInt(1, page);
			psmt.setInt(2, page);

			rs = psmt.executeQuery();// 결과 가져옴, 여러건 담김
			while (rs.next()) {// 담긴 수만큼 루프
				// rs -> list 변환
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));// 테이블 칼럼이름
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdContent(rs.getString("brd_content"));
				board.setBrdWriter(rs.getString("brd_writer"));
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();			
		}
		return list;
	}

	@Override
	public int getTotal() {
		query = "select count(*) as cnt from board";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();			
		}
		return 0;
	}

	@Override
	public boolean modify(Board board) {
		// query = "update board set brd_content = '"+board.getBrdContent()+"' where
		// brd_no = "+board.getBrdNo();
		query = "update board set brd_content = ? where brd_no = ?";// ? : psmt 실행 후 파라미터 값을 넣어주겠다는 뜻
		System.out.println(query);
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, board.getBrdContent());
			psmt.setInt(2, board.getBrdNo());
			int r = psmt.executeUpdate();
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();			
		}
		return false;
	}

	@Override
	public boolean remove(int brdNo) {
		query = "delete from board where brd_no = " + brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate();// insert, update, delete를 실행할 때 사용하는 메소드, r: 처리한 건수
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();			
		}
		return false;
	}

	@Override
	public Board search(int brdNo) {
		query = "select * from board where brd_no = " + brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery(); // select를 실행할 때 사용하는 메소드
			if (rs.next()) {
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
		}finally {
			disconn();			
		}
		return null;
	}

	@Override
	public void save() {

	}

	@Override
	public String getResponseUser(int brdNo) {
		query = "select brd_writer from board where brd_no = ?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getString("brd_writer");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
		return null;
	}
}
