package co.yedam.operator;


//은행 App.

public class OperatorExe2 {
	public static void main(String[] args) {
		
		java.util.Scanner scn = new java.util.Scanner(System.in); //ctr + shift + o -> import 스캐너 자동생성
		
		int balance = 0; //10만원 이상 불가, -금액 불가.
		boolean run = true;
		
		while(run) {
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			System.out.println("선택>>");
			
			int menu = Integer.parseInt(scn.nextLine());
			if(menu == 1) {
				System.out.println("입금액 입력>>");
				int money = Integer.parseInt(scn.nextLine());
				if(balance + money < 100000 && balance + money > 0) {
					balance += money;
					System.out.println("잔액: "+balance);
				}else {
					System.out.println("입금 가능 금액이 아닙니다.");
				}
			}else if(menu == 2) {
				System.out.println("출금액 입력>>");
				int money2 = Integer.parseInt(scn.nextLine());
				if(balance - money2 < 100000 && balance - money2 > 0) {
					balance -= money2;
					System.out.println("잔액: "+balance);
				}else {
					System.out.println("출금 가능 금액이 아닙니다.");
				}
			}else if(menu == 3) {
				System.out.println("잔액 :" + balance);
			}else if(menu == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		System.out.println("end of prog.");
		// 깃허브 커밋
		// Pull
	}
}
