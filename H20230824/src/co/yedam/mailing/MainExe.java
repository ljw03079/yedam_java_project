package co.yedam.mailing;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MainExe {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// 음원실행 쓰레드 생성(멀티스레드)
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				wavplayer();
			}
		});
		thread.start();//

		boolean run = true;
		while (run) {
			System.out.println("1.추가 2.목록 3.메일 4.종료");
			System.out.print("선택>> ");
			switch (scn.nextInt()) {
			case 1:
				System.out.println("추가합니다.");
				break;
			case 2:
				System.out.println("목록보기입니다.");
				break;
			case 3:
				scn.nextLine();
				mailsend();
				break;
			case 4:
				System.out.println("프로세스를 종료합니다.");
				run = false;
			}
		}
		System.out.println("end of prog.");
	}

	static void wavplayer() {
		while (true) {//메인에 있는 스레드 끝나더라도 계속 실행함 없으면 메인에 있는 스레드 끝나면 같이 끝남
			try {
				File file = new File("C:/temp/sample.wav");
				AudioInputStream ais = AudioSystem.getAudioInputStream(file);
				Clip clip = AudioSystem.getClip();
				clip.open(ais);
				clip.start();

				Thread.sleep(clip.getMicrosecondLength()/10000);//실행했다가 몇초 정도 기다림. 없으면 계속 실행만 함. 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static void mailsend() {

		System.out.print("수신자 이메일: ");
		String to = scn.nextLine();

		System.out.print("제목: ");
		String title = scn.nextLine();

		System.out.print("내용: ");
		StringBuilder sb = new StringBuilder();
		sb.append("<p>비밀번호 초기화 메일입니다.</p>");//html 태그도 넣을 수 있음
		sb.append("<p>12345</p>");
		//반복문 통해 멀티라인 가능
		String content = scn.nextLine();
		
		sb.append("<p>"+content+"</p>");
		sb.append("<b>Bye~~</b>");

		content = sb.toString();
		
		SendMail sendMail = new SendMail();
		sendMail.sendMail(to, title, content);

		scn.close();
	}
}
//로그인 3번 실패하면 메일로 비밀번호 초기화 보내고 안내받은 비밀번호 입력하면 로그인되도록 만들기
