package co.yedam.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.common.Dao;
import co.yedam.board.vo.Reply;

public class ReplyServiceJdbc implements ReplyService {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;

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
	public boolean rpAdd(Reply reply) {
		query = "insert into reply (rp_no, brd_no, rp_content, rp_writer)"
				+ "values (select nvl(max(rp_no),0)+1 from board), ?, ?, ?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, reply.getBrdNo());
			psmt.setString(2, reply.getRpContent());
			psmt.setString(3, reply.getRpWriter());
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public List<Reply> rpList() {
		List<Reply> list = new ArrayList<>();
		conn = Dao.conn();
		query = "select * from reply";
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply();
				reply.setRpNo(rs.getInt("rp_no"));
				reply.setBrdNo(rs.getInt("brd_no"));
				reply.setRpContent(rs.getString("rp_content"));
				reply.setRpWriter(rs.getString("rp_writer"));
				list.add(reply);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	@Override
	public boolean rpRemove(int rpNo) {
		query = "delete from reply where rp_no = ?";
		conn = Dao.conn();
		
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public boolean rpSearch(int brdNo) {
		query = "select * from reply where brd_no = ?";
		conn = Dao.conn();
		
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Reply reply = new Reply();
				reply.setRpNo(rs.getInt("rp_no"));
				reply.setBrdNo(rs.getInt("brd_no"));
				reply.setRpContent(rs.getString("rp_content"));
				reply.setRpWriter(rs.getString("rp_writer"));
				reply.showInfo();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return false;
	}

	@Override
	public void rpSave() {

	}

}
