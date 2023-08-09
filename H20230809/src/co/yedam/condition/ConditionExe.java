package co.yedam.condition;

public class ConditionExe {
	public static void main(String[] args) {
		//임의의 수 1,2,3 생성, 1:가위, 2:바위, 3:보
		int num = (int)(Math.random()*3)+1;
		if(num == 1) {
			System.out.printf("%d은 가위입니다.",num);
		}else if(num == 2) {
			System.out.printf("%d은 바위입니다.",num);
		}else {
			System.out.printf("%d은 보입니다.",num);
		}
		
		switch(num) {
		case 1:
			System.out.printf("%d은 가위입니다.",num);
			break;
		case 2:
			System.out.printf("%d은 바위입니다.",num);
			break;
		default:
			System.out.printf("%d은 보입니다.",num);
		}
		
		char chr = 97; //2바이트 정수형 타입, 각 숫자에 매핑되어있는 데이터 값이 있음. 97 => a
		//65~68
		char grade = (char) ((Math.random()*4)+65); //큰 값에서 작은 값으로 변환할 때는 캐스팅이 꼭 필요함. 작은 값에서 큰 값으로 변환은 자동변환
		switch(grade) { //math.random => 8바이트, char => 2바이트, 캐스팅: 강제변환
		case 65: System.out.println(grade+" VVIP 혜택을 받으실 수 있습니다."); break;
		case 66: System.out.println(grade+" VIP 혜택을 받으실 수 있습니다."); break;
		case 67: System.out.println(grade+" 우수 회원 혜택을 받으실 수 있습니다."); break;
		default: System.out.println(grade+" 일반 회원 혜택을 받으실 수 있습니다."); break;
		}
		//정수형 타입이기 때문에 조건에 equals가 아닌 비교연산자 사용
		System.out.println(grade == 'A');
		
		//자동형 변환
		byte b1 = 2;
		byte b2 = 2;
		int result = b1 + b2; //왼쪽 항과 오른쪽 항은 타입이 같아야함 바이트보다 인트가 더 크기때문에 자동 변환
		
	}
}
