package co.yedam.classes.student;

public class Student {
	//필드, 값을 담아놓기 위한 용도, 변수와 비슷하지만 변수라 하지않고 필드라 함. (변수는 메소드 안에서)
	private int stdNo; //해당 클래스 내에서만 접근 가능. 외부 클래스,패키지에서 접근 못함. 메소드를 통해 값을 넣을 수 있음. 
	private String stdName;
	private int score;
	
	//생성자: 필드의 값 초기화, 클래스의 이름과 똑같이 만듦, 타입지정할 필요 없음
	//생성자 오버로딩: 매개변수의 갯수나 이름이 다르면 여러개 생성 가능
	//this(): 기본 생성자를 가리킴
	Student(){
		//기본생성자(안에 아무것도 없음), int -> 0, String -> null
		//생성자 정의안해주면 실행클래스에서 에러
		//기본생성자는 정의 안해줘도 컴파일러가 만들어줌
		//다른 매개변수를 받는 생성자가 있으면 기본생성자 정의안했을때 에러
		//인스턴스를 만들어주기 위해 정의
	}
	Student(int stdNo){ //매개변수를 받음, 매개변수에 값을 넣으면 해당 필드를 채워줌
		this.stdNo = stdNo; //this -> 만들어진 인스턴스의 stdNo(필드를 가리킴), this가 없으면 변수로 인식
	}
//	Student(int stdNo, String stdName){
//		this.stdNo = stdNo;
//		this.stdName = stdName;
//	}
	Student(int stdNo, String stdName, int score){
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.score = score;
	}
	
	//메소드, 기능, 리턴 타입 필요
	
	void stdInfo() {
		System.out.println("학번: "+stdNo+", 학생이름: "+stdName+", 점수: "+score);
	}
	
	void setStdNo(int stdNo) {
		this.stdNo = stdNo;
		
	}
	void setStdName(String stdName) {
		this.stdName = stdName;
		
	}
	void setStdScore(int score) { //음수가 들어오지 못하게 함
		if(score<0) {
			this.score = 0;
		}else {
			this.score = score;			
		}
	}
	//getter 값을 불러옴, 마우스 오른쪽 -> Source -> generate getter 메뉴를 통해 생성 가능
	public int getStdNo() {
		return stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public int getScore() {
		return score;
	}
	
}
