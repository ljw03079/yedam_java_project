package co.yedam.thread;

import java.awt.Toolkit;

public class BeepPrintExe {
	public static void main(String[] args) {
		//프로그램 실행 -> 프로세스(크롬, 한글, 자바 등...)
		//프로세스 안에 싱글스레드(하나의 작업), 멀티스레드(여러개의 작업/채팅, 파일 업로드 등)

		//싱글 스레레드 작업
//		Toolkit toolkit = Toolkit.getDefaultToolkit();//소리가 날 수 있게 만듬
//		for(int i=0; i<5; i++) {
//			toolkit.beep();
//			try {
//				Thread.sleep(500);//실행되고 있는 기능을 0.5초 동안 기다렸다가 하게 하는 기능
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		//스레드 생성(멀티스레드 작업), 메인스레드 작업스레드 병렬처리
		Thread beep;
		beep = new WorkThread();//두가지 방법, 새로운 스레드를 만듦
		beep = new Thread(new BeepTask());
		//1.Runnable 인터페이스를 구현하는 클래스 생성 후 스래드 클래스 생성자의 매개값으로 넣어줌
		//2.Thread를 상속하는 클래스를 작성
		//둘 다 run메소드를 오버라이딩 해야함.
		
		//익명클래스 사용(클래스 만들필요 없음)
		//1-1. Runnable 인터페이스를 구현하는 익명객체 생성, 기능을 매개값으로 넣음
		beep = new Thread(new Runnable() {

			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0; i<5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		// Functional Interface(구현할 메소드 한개만 존재) -> 람다표현식
		// Runnable, run이 명확하니 생략
		beep = new Thread(() -> {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0; i<5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		
		beep.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");//하나의 스레드 이기때문에 띵 소리 나고 나서 콘솔 출력해줌
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
