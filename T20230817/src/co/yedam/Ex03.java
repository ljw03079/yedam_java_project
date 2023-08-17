package co.yedam;

public class Ex03 {
	public static void main(String[] args) {
		int[] intAry = new int[5];
		
		for(int i=0; i<5; i++) {
			int randomNum = (int) ((Math.random()*10)+1);
			intAry[i] = randomNum;
			System.out.println(intAry[i]);
		}
		
		int max = intAry[0];
		int min = intAry[0];
		for(int i=0; i<intAry.length; i++) {
			if(max < intAry[i]) {
				max = intAry[i];
			}
			if(min > intAry[i]) {
				min = intAry[i];
			}
		}
		System.out.printf("최소값: %d, 최대값: %d", min, max);
	}
}
