package co.yedam.interfaces;

public interface Dao {
	//인터페이스: 규칙선언 -> 해당 클래스에서 메소드 반드시 구현
	/*(static final)*/ double pi = 3.14; //필드: 상수, 값이 선언되어야함
	
	void insert();
	void update();
	void delete();
	void select();
	//abstract 안붙여도 추상메소드
	
}
