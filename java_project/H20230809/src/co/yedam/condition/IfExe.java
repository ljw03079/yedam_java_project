package co.yedam.condition;

public class IfExe {
	public static void main(String[] args) {
		int score = 85;
		score = (int)(Math.random()*100)+1; //캐스팅: 타입 변환, random은 0부터 1까지 난수 발생(1포함하지 않음)
		String grade = "";
		
		if(score > 90) {
			grade = "A";
		} else if(score > 80) {
			grade = "B";
		} else if(score > 70) {
			grade = "C";
		} else if(score > 60) {
			grade = "D";
		}
		else {
			grade = "F";
		}
		
		int score1 = score / 10; // 95/10=>9.5인데 정수타입이므로 9만 반환
		switch(score1) {
		case 9:
			grade = "A";
			break; //해당 구문만 실행하고 아래 코드 실행하지 않도록 break; 넣어줘야 함
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default: // switch 구문에서 else 역할
			grade = "F";
		}
		System.out.printf("점수는 %d, 등급은 %s입니다.", score, grade);
	}
}
