package co.yedam.interfaces;

public class MysqlDao implements Dao {//다중인터페이스 가능, 인터페이스 implements 인터페이스도 가능

	@Override
	public void insert() {//인터페이스 메소드는 전부 추상메소드
		// TODO Auto-generated method stub
		System.out.println("Mysql 입력기능.");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Mysql 수정기능.");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Mysql 삭제기능.");
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("Mysql 조회기능.");
	}
	
}
