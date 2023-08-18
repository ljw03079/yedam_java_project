package co.yedam.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ThrowExe {
	public static void main(String[] args) {
		try {
			dbSearch();
		} catch (Exception e/*ClassNotFoundException | SQLException e*/) { //처리하는 구문이 똑같으니 |를 통해 같이 적어주면 됨 
			//최상위 Exception 클래스 적어주면 모든 예외에 대해 처리를 걸어줌
			
			// TODO Auto-generated catch block
			e.printStackTrace(); //에러나는 위치에 로그를 찍어줌
		} /*catch(SQLException e1) {
			e1.printStackTrace();
		}*/
	}
	
	public static void dbSearch() throws Exception /*ClassNotFoundException, SQLException*/ { //throws: dbSearch()를 호출한 곳에서 예외처리하도록 떠넘김
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employees");
		while(rs.next()) {
			System.out.println("사원번호: "+rs.getInt("employee_id")+", 이름:"+rs.getString("first_name"));
		}
	}
}
