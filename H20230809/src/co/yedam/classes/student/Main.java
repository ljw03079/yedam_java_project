package co.yedam.classes.student;

public class Main { //제일 먼저 실행되는 클래스 Main
	public void main(String[] args) {
//		Calculator cal = new Calculator(); //메모리상 탑재가 됨 /인스턴스
//		double result = cal.sum(20, 40);
//		System.out.println(result);
		
		double result = Calculator.multi(10, 20);
		System.out.println(result);
	}
	public void start() { //main에 static이 없을경우 
		Main main = new Main();
		main.main(null);
	}
}
