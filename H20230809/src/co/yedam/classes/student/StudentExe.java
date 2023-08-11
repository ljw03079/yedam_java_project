package co.yedam.classes.student;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student(); //Student() -> 생성자 
		//new를 통해 힙공간에 객체 생성 후 s1에 주소값을 부여
		//s1이라는 인스턴스 생성
//		s1.stdNo = 100;
		s1.setStdNo(100); //매개값을 통해 값을 담음
//		s1.stdName = "Hong";
		s1.setStdName("Hong");
//		s1.score = 80;
		s1.setStdScore(-80);
		
		s1.stdInfo();
		System.out.println(s1.getStdName());
		
		Student s2 = new Student(101, "Hwang", 70); //드래그하고 ctl -> 해당생성자로 이동
		s2.stdInfo();
		
	}
}