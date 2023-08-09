package co.yedam.variable;

public class VairableExe2 {
	public static void main(String[] args) {
		int num1 = 10;
		String str = "홍길동";
		str = "김길동";
		
		//홍길동, 20 등 복합형태의 변수를 담고 싶으면 class 이용
		Person hong = new Person();
		hong.name = "홍길동";
		hong.age = 20;
		hong.weight = 67.8;
		
		//hong = "홍길동"; 양변에 타입이 안맞음, 왼쪽은 Person 오른쪽은 string
		hong = new Person(); //초기화
		
		System.out.println("이름은 "+hong.name+", 나이는 "+hong.age+", 몸무게는 "+hong.weight);
		
		VariableExe3 exe3 = new VariableExe3();
		exe3.showInfo();
		exe3.helloMsg();
	}
}
