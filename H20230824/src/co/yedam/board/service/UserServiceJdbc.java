package co.yedam.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.yedam.board.common.Dao;
import co.yedam.board.vo.User;

public class UserServiceJdbc implements UserService {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;

	void disconn() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User checkLogin(User user) {
		query = "select * from users where user_id=? and user_pw=?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getUserPw());
			rs = psmt.executeQuery(); // select
			if (rs.next()) {
				User nuser = new User();
				nuser.setUserId(rs.getString("user_id"));
				nuser.setUserNm(rs.getString("user_nm"));
				nuser.setUserPw(rs.getString("user_pw"));

				return nuser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}

	@Override
	public void initPassword(User user) {
		query = "update users set user_pw = ? where user_id = ?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, user.getUserPw());
			psmt.setString(2, user.getUserId());
			psmt.executeUpdate();// insert, update, delete
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

}
