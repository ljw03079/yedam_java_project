package co.yedam.variable;

public class VariableExe3 {
	
	int num = 100; //해당 클래스 내 블록에서 유효한 값
	
	public void showInfo() {
		int num = 100 + this.num; //클래스에 소속되어 있는 변수나 메소드는 this로 표현
		System.out.println("num: "+num);
		int num1 = 200;
	}
	//showInfo함수가 끝나면 변수가 메모리에서 사라짐
	//로컬변수는 선언된 실행블럭안에서만 유효값
	
	/*public void printNum() {
		System.out.println("num: "+num1); //num1은 해당 메소드내에서만 유효
	}*/
	
	public void helloMsg() {
		int num = 200 + this.num;
		System.out.println("num: "+num);
	}
}

