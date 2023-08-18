package co.yedam.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombok 라이브러리를 활용해 get,set 메소드 생성
@AllArgsConstructor //필드를 채워주는 생성자
@NoArgsConstructor //기본생성자
public class Student {
	private int stdNo;
	private String stdName;
	private int score;
}
