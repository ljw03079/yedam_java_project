package co.yedam.stream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExe {
	public static void main(String[] args) {
		try {
			File file = new File("src/co/yedam/stream/FileCopy.java");
			FileReader fr = new FileReader(file);
			char[] buf = new char[100];
			while (true) {
				int val = fr.read(buf);// 반환되는 타입: int, buf가 있으면 크기를 반환, 매개변수가 없으면 문자 반환, 반복문 필요
				if (val == -1) {
					break;
				}
				for (int i = 0; i < val; i++) {
					System.out.print(buf[i]);
				}
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
