package co.yedam.stream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterExe {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("C:/temp/names.txt");
			Scanner scn = new Scanner(System.in);

			System.out.println("start");
			while (true) {
				String line = scn.nextLine();
				if(line.equals("quit")) {
					break;
				}
				fw.write(line+"\n");//2바이트씩 씀, char타입이 2byte
			}
			fw.flush();
			fw.close();
			scn.close();//원래 클로즈해주는게 규칙상 맞음
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
