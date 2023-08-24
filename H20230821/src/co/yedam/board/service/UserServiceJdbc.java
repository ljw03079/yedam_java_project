package co.yedam.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.yedam.board.common.Dao;
import co.yedam.board.vo.User;

public class UserServiceJdbc implements UserService{
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
	public User checkLogin(User user) {
		query = "select * from users where user_id = ? and user_pw = ?";
		System.out.println(query);
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getUserPw());
			rs = psmt.executeQuery();
			if(rs.next()) {
				User nuser = new User();
				nuser.setUserId(rs.getString("user_id"));
				nuser.setUserPw(rs.getString("user_pw"));
				nuser.setUserName(rs.getString("user_nm"));
				return nuser;
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
