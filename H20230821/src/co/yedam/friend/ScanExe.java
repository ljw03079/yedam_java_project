package co.yedam.friend;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScanExe {
	public static void main(String[] args) {
		File file = new File("src/co/yedam/friend/friends.txt");
		Scanner scn = null;
		try {
			scn = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String line = scn.nextLine();//한줄을 읽어옴
//		while (scn.hasNext()) {//공란을 기준으로 값을 계속 읽어옴
//			String line = scn.next();//공백기준 값을 가져옴
//			System.out.println(line);
//		}
//		System.out.println("end of line");

		List<Friend> friends = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		while (true) {
			String line = null;
			try {
				line = scn.nextLine();
			} catch (NoSuchElementException e) {// 더이상 읽을 수 있는게 없으면 예외
				break;// 반복문 빠져나옴
			}
			String[] data = line.split(" ");// 공란을 기준으로 배열을 만들어줌
			try {
				Friend friend = new Friend(data[0], data[1], sdf.parse(data[2]));
				friends.add(friend);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 반복문 출력
		for (Friend fnd : friends) {
			System.out.println(fnd.toString());
		}
		System.out.println("end of line");
	}
}
