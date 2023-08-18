package co.yedam.exception;

//예외: 프로그램이 정상적으로 종료시점까지 진행하기 위해 처리
public class NullPointExe {
	public static void main(String[] args) {
		String msg = null; // 참조타입
		msg = "123";

		try {// 예외발생할 수 있는 블럭, 예외발생하지 않으면 try, catch 구문 넘어감
			System.out.println(msg.toString());
			int val = Integer.parseInt(msg);
			System.out.println("결과는 "+val);//타입에 맞는 예외처리를 걸어줘야함
		} catch (NullPointerException e) {// 해당예외가 발생할때 실행할 블럭, 종료되지않고 프로그램이 끝까지 실행됨
			System.out.println("msg 값이 null 참조합니다.");
			System.out.println("예외가 발생했습니다.");
		} catch(NumberFormatException e1) {
			System.out.println("msg 값을 숫자로 변환할 수 없습니다.");
		} finally {
			System.out.println("예외의 발생과는 상관없이 실행할 코드 작성");
		}
		System.out.println("end of prog.");
	}
}

//Runtime Error: 실행은 됨, 일반예외: 실행안되기 때문에 try/catch구문 꼭 넣어줘야 함
//Cast 에러: instanceOf 쓰는게 나음