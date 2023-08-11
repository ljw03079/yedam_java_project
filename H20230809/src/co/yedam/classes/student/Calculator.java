package co.yedam.classes.student;

public class Calculator {
	double pi = 3.14;//인스턴스 멤버(new 연산자로 만들어야함): 메모리 준비되어야지 사용가능
	
	//인스턴스 멤버
	public double sum(double n1, double n2) {
		return n1 + n2;
	}//static 없음: static이 없는 것들 -> member
	public double minus(double n1, double n2) {
		return n1 - n2;
	}
	public static double multi(double n1, double n2) {
		return n1 * n2;}
}//static(정적메소드): 클래스가 메모리에 로딩될때 static으로 선언한 메소드는 메모리에 상주하면서 사용 준비되어있도록 함

