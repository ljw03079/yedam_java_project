package co.yedam.array;

public class ArrayExe3 {
	public static void main(String[] args) {
		
		Student[] students = new Student[3];
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.score = 85;
		s1.height = 178.9;
		//s1.gender = "남";
		s1.gender = Gender.WOMEN;
		Student s2 = new Student();
		s2.name = "김길동";
		s2.score = 80;
		s2.height = 169.9;
		//s2.gender = "남자";
		s2.gender = Gender.MEN;
		Student s3 = new Student();
		s3.name = "박길동";
		s3.score = 90;
		s3.height = 188.9;
		//s3.gender = "Men";
		s3.gender = Gender.MEN;
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;

		// students[0].name + students[0].score;
		int max = 0;
		String nameStu = "";
		for(int i=0; i<students.length; i++) {
			if(max < students[i].score) {
				max = students[i].score;
				nameStu = students[i].name;
			}
		}
		System.out.println(max+" "+nameStu);
		
		String[] names = {"홍길동","김길동","박길동","최길동"};
		int[] scores = {85,88,92,75};
		
		max = scores[0];
		//String name = "";
		int idx = 0;
		for(int i=0; i<scores.length; i++) {
			if(max<scores[i]) {
				max = scores[i];
				idx = i; //name = names[i]로 받아서 name 출력
			}
		}
		System.out.println(names[idx]);
		
	}
}
