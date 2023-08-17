package co.yedam.abstracts;

public class MainExe {
	public static void main(String[] args) {
		//Animal animal = new Animal(""); //추상클래스는 인스턴스를 만들 수 없음
		Animal animal = new Dog("멍멍이");
		animal.sound();//반드시 구현되어야함.
		
		animal = new Cat("야옹이");
		animal.sound();//다형성 (인스턴스에 담긴 클래스에 따라 기능실행)
	}
}
