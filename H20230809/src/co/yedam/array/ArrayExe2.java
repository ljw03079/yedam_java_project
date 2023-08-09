package co.yedam.array;

public class ArrayExe2 {
	public static void main(String[] args) {
		//정수를 5개 담을 수 있는 배열
		int[] ary = new int[5];
		//1 ~ 100 임의의 값, 배열의 첫번째 위치에 담기, 5개 합, 평균 구하기
		int sum = 0;
		for(int i=0; i<5; i++) {
			ary[i] = (int)((Math.random()*100)+1);			
			System.out.println(ary[i]);
			sum += ary[i];
		}
		double avg = sum/5.0; //오른쪽 항을 5.0으로 넣어서 소수점자리까지 나오게 함. double 타입으로 변환
		System.out.printf("합계는 %d이고 평균은 %f입니다\n", sum, avg);
		//
		int num1, num2, num3;
		num1 = 56;
		num2 = 72;
		num3 = 67;
		//큰 값:
		int max;
		if(num1>num2) {
			if(num1>num3) {
				max = num1;
			}else {
				max = num3;
			}
		} else {
			if(num2>num3) {
				max = num2;
			}else {
				max = num3;
			}
		}
		System.out.println(max);
		
		int[] numAry = {num1, num2, num3};
		int maxAry = numAry[0];
		for(int i=0; i<numAry.length; i++) {
			if(maxAry < numAry[i]) {
				maxAry = numAry[i];
			}
		}
		System.out.println(maxAry);
	}
}
