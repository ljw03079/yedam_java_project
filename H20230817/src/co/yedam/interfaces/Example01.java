package co.yedam.interfaces;

public class Example01 {
	public static void main(String[] args) {
		int[][] intAry = new int[5][5]; //intAry[0]: 배열
		
		//System.out.println(intAry[2][2]);
		
//		int ele = 0;
//		for(int i=0; i<5; i++) {
//			for(int j=0; j<5; j++) {
//				ele = ele + 1;
//				intAry[i][j] = ele;
//				System.out.printf("%3d",intAry[i][j]);
//			}
//			System.out.println();
//		}
		
		
		int no = 1;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				intAry[i][j] = no++;
				System.out.printf("%3d",intAry[i][j]);
			}
			System.out.println();
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.printf("%3d",intAry[j][i]);
			}
			System.out.println();
		}
		
		for(int i=4; i>=0; i--) {
			for(int j=0; j<5; j++) {
				System.out.printf("%3d",intAry[j][i]);
			}
			System.out.println();
		}
	}
}
