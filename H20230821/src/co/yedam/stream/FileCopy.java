package co.yedam.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileInputStream fis = new FileInputStream("C:/Temp/img1.jpg");
			FileOutputStream fos = new FileOutputStream("C:/Temp/copy.jpg");
			byte[] buf = new byte[100];//빨리 copy됨, 100바이트
			while (true) {
				int val = fis.read(buf);//100바이트씩 읽음
				if(val == -1) {
					break;
				}
				fos.write(buf);//2mega -> 2백만번 돌아감
			}
			fis.close();
			fos.flush();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("end - "+(end-start)+" ms");
	}
}
