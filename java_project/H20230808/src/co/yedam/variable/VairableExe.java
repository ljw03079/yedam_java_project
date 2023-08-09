package co.yedam.variable;

public class VairableExe {
	public static void main(String[] args) {
		//변수 선언
		//정수형 변수의 유형: byte(1바이트), short(2바이트), int(8바이트), long
		//byte: -128 ~ 127 1바이트는 8비트 1비트당 2가지 담을 수 있음
		//short: -32768 ~ 32767
		int num1 = 5; //초기화.
		int num2;
		
		num1 = 10; 
		num2 = 20; //초기화.
		
		int result = num1 + num2;
		
		byte b1 = 10;
		byte b2 = 20;
		
		//byte bb3 = b1 + b2; //Type mismatch: cannot convert from int to byte
		//정수의 연산은 int로 담김
		int b3 = b1 + b2;
		
		int i1 = 100;
		byte b4 = 10;
		b3 = i1 + b4; //자동형변환해서 연산. b4는 byte이지만 자동으로 int 변환
		
		//실수유형
		//float, double
		double dbl1 = 10.23223;
		double dbl2 = 20;
		double dbl3 = dbl1 + dbl2;
		
		float f1 = 10.1F; //f나 F지정 안해주면 double로 인식
		float f2 = 10.001f;
		float f3 = f1 + f2;
		System.out.println("f3 : "+f3); //실수는 무한대이기 때문에 실수값울 근사치로 리턴, 정확한 값을 연산받고 싶으면 class 이용
	}
}
