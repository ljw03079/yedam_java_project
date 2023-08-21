package co.yedam.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExe {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/out.data");
			fos.write(100);//쓸때는 write, 읽을때는 read, 한 바이트씩 씀
			fos.write(110);//값을 바이트 타입으로 저장, 바이트값이기 때문에 텍스트를 볼 수는 없음
			fos.write(255);//2 4 8 16 32 128 256/ 바이트는 담을 수 있는 값의 범위가 0~255
			//256: 0, 257: 1 ...
			
			fos.flush();//버프의 캐시값을 비움
			fos.close();//사용한 리소스를 운영체제에 환원 (안적어주면 계속 열려있는 상태)
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
