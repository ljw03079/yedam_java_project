package co.yedam.array;

public class ArrayExe1 {
	public static void main(String[] args) {
		//배열선언
		int[] intAry = null; // null로 초기화 가능
		intAry = new int[10]; //정수값을 담을 수 있는 공간 10개 만듦
		intAry = new int[] {12, 25, 67, 23};
		System.out.println(intAry[0]);
		intAry[0] = 22;
		System.out.println(intAry[0]);
		//intAry = 50; //왼쪽은 배열, 오른쪽은 정수타입
		int[] intAry2 = {55, 47, 90};
		intAry = intAry2;
		System.out.println(intAry[0]);
		
		int sum = 0;
		sum += intAry[0];
		sum += intAry[1];
		sum += intAry[2];
		//sum += intAry[3];
		
		sum = 0;
		for(int i=0; i<3; i++) {
			sum += intAry[i];
		}
		System.out.println(sum);
		
		
	}
}
