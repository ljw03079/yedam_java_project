package co.yedam.generic;

import java.util.ArrayList;
import java.util.List;

public class ListExe {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();//List는 인터페이스, new로 객체 생성못함
		list.add("Hello");//메소드
		list.add(new String("World"));
		list.add("Good");
		
		String result = list.get(0);//배열은 ary[0], 해당되는 인덱스
//		System.out.println(result);
		
		for(int i=0; i<list.size(); i++) {//배열은 length,컬렉션은 size()
			System.out.println(list.get(i));
		}
		
		list.set(1, "result");
		System.out.println("===수정 후===");
		list.remove(1);//해당되는 위치 삭제
		list.clear();//전체삭제
		
		for(String str : list) {//확장 for문
			System.out.println(str);
		}
	}
}