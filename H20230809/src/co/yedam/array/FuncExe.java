package co.yedam.array;

public class FuncExe {
	public static void main(String[] args) {
		printStar();
		printStar(3);
		printString(5,"※");
		int n3 = sum(5,7);
		System.out.println(n3);
		int[] intAry = {5,7,9,2,6};
		int n4 = sum(intAry);
		System.out.println(n4);
		
		getFriend("홍길동","010-4567-2345",Gender.MEN).showInfo();
		Friend f = getFriend("홍길동","010-4567-2345",Gender.MEN);
		f.showInfo();
	}
	
	public static void printStar() {
			System.out.println("*");
	}

	public static void printStar(int times) { //메소드 괄호 안의 변수 : 매개변수, 필요한 만큼 선언 가능
		for(int i=0; i<times; i++) {
			System.out.println("*");			
		}
	}
	
	public static void printString(int times, String str) { 
		for(int i=0; i<times; i++) {
			System.out.println(str);			
		}
	}
	
	public static int sum(int n1, int n2) {
		int result = n1 + n2;
		return result; //반환하는 값이 있음
	}
	
	public static int sum(int[] arry) { //배열을 매개값으로 받음
		int sum = 0;
		for(int i=0; i < arry.length; i++) {
			sum += arry[i];
		}
		return sum;			
	}
	
	public static Friend getFriend(String name, String phone, Gender gender) { //Friend 타입 반환
		Friend f = new Friend();
		f.name = name;
		f.phone =phone;
		f.gender = gender;
		return f;
	}
}
