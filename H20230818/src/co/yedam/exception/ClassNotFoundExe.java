package co.yedam.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//메이븐 -> ojdbc8 v19.3.0 다운 후 build path로 jar 적용
public class ClassNotFoundExe {
	public static void main(String[] args) {
		//db연결처리시 발생할 수 있는 예외
		try {
			Class.forName("oracle.jdbc.OracleDriver"); //이 클래스가 있는지 체크 후 있으면 인스턴스 생성 (드라이브 연결)
		} catch (ClassNotFoundException e) {//최상위 클래스: exception 클래스, 일반예외는 try/catch 반드시 걸어줘야함
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");//sql접속url, 계정id, pw -> conn: db연결객체
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employees");//매개값: 실행할 쿼리, ResultSet: 데이터 담아두기 위해 사용
			while(rs.next()) {
				System.out.println("사원번호: "+rs.getInt("employee_id")+", 이름:"+rs.getString("first_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end of prog.");
	}
}
