package co.yedam.generic;

public class MainExe {
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.set("Hello");
		String result = /*(String)*/ box.get();//Object 타입이니 캐스팅
		
		Box<Integer> ibox = new Box<Integer>();
		ibox.set(10);//10(int)가 아니고 (Integer):wrapper -> 기본타입을 클래스로 변환
		Integer iresult = ibox.get();
	}
}
