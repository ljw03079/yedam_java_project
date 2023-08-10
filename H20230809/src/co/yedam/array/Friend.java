package co.yedam.array;

public class Friend {
	String name;
	String phone;
	Gender gender;
	
	// 메소드: 클래스 안의 함수, 함수에도 return 타입을 지정해주어야 함. void: 리턴되는 타입이 없음
	void showInfo(){
		System.out.printf("이름:%s, 연락처: %s, 성별: %s\n",name, phone, gender == Gender.MEN ? "남" : "여");
	}
	void briefInfo() {
		System.out.printf("이름:%s, 연락처: %s\n",name, phone);
	}
}
