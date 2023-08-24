package co.yedam.thread;

import java.awt.Toolkit;

public class WorkThread extends Thread{
	
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();//소리가 날 수 있게 만듬
		for(int i=0; i<5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);//실행되고 있는 기능을 0.5초 동안 기다렸다가 하게 하는 기능
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
