package co.yedam.loop;

public class ForExe {
	public static void main(String[] args) {
		int sum = 0;
		sum = sum + 1;
		sum = sum + 2;
		sum = sum + 3;
		sum = sum + 4;
		sum = sum + 5;
		
		sum = 0; //브래이크포인트 잡은 후 디버깅(벌레모양 아이콘) => f6으로 다음 스탭
		for(int i=1; i<=5; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
		
		//실습
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
		
		sum = 0;
		for(int i=1; i<=100; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		for(int i=2; i<=9; i++) {
			System.out.printf("***%d 단*** \n", i);
			for(int j=1; j<=9; j++) {
				System.out.printf("%d * %d = %d \n", i, j, i*j);
			}
		}
		
//		int i = 1;
//		while(i<=10) {
//			System.out.println(i);
//			i++;
//		}
//		i = 1;
//		sum = 0;
//		while(i<=100) {
//			sum += i;
//			i++;
//		}
//		System.out.println(sum);
		
		while(true) {
			int num = (int) (Math.random()*6)+1;
			System.out.println(num);
			if(num == 6) {
				break;
			}
		}
		
		for(int j=1; j<=10; j++) {
			if(j % 2 !=0) {
				continue;
			}
			System.out.println(j);
		}
		
		//확인문제
		//5
		String stars = "";
		for(int i=0; i<4; i++) {
			for(int j=0; j<i+1; j++) {
				stars += "*";
			}
			System.out.println(stars);
			stars = "";
		}
		//6
		String stars2 = "";
		for(int i=0; i<4; i++) {
			for(int j=0; j<3-i; j++) {
				stars2 += " ";
			}
			for(int k=0; k<i+1; k++) {
				stars2 += "*";
			}
			System.out.println(stars2);
			stars2 = "";
		}
		//4
		for(int i=1; i<=10; i++) {
			int x = i;
			int y = (60-4*x)/5;
			if(y > 10) {
				continue;
			}
			System.out.printf("(%d, %d)\n",x,y);
		}
		//3
		boolean run = true;
		while(run) {
			System.out.print("주사위 던지기 >>");
			int a = (int)((Math.random()*6)+1);
			int b = (int)((Math.random()*6)+1);
			System.out.printf("(%d, %d)\n", a, b);
			int sumAB = a + b;
			if(sumAB != 5) {
				continue;
			}
			else {
				break;
			}
		}
		System.out.println("주사위던지기 종료");
		//2
		int sum3 = 0;
		for(int i=1; i<=100; i++) {
			if(i%3 == 0) {
				sum3 += i;
			}
		}
		System.out.println(sum3);
	}
}
