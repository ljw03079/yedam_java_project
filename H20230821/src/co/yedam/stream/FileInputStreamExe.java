package co.yedam.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamExe {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:/Temp/out.data");
			while(true) {
				int val = fis.read();//한 바이트씩 읽음, int타입
				if(val == -1) {//다 읽으면 -1이라는 값을 반환
					break;//반복문 빠져나감
				}
				System.out.println(val);
				
			}
			
			fis.close();//사용하고 있는 리소를 운영체게에 환원
		} catch (IOException e) {//FileNotFound예외보다 IO예외가 더 상위
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
