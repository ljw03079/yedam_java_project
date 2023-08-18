package co.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		//ArrayList: 인덱스로 저장하기때문에 중복값 저장가능, HashSet(중복x,순서x 무작위로 저장): 중복된 값은 저장불가
		
		Set<String> set = new HashSet<>();//Set 인터페이스
		set.add("Hong");
		set.add("Hwang");
		set.add("Kim");
		set.add("Hong");
		
		for(String str : set) {
			System.out.println(str);
		}
		
		Set<Member> memberSet = new HashSet<>();
		memberSet.add(new Member(101,"Hong"));
		memberSet.add(new Member(102,"Hwang"));
		memberSet.add(new Member(103,"Kim"));
		memberSet.add(new Member(101,"Hong"));//같은 값으로 인식하지 않음, HashCode 오버라이딩 -> 같은 값으로 인식
		
		
		for(Member str : memberSet) {
			System.out.println(str);
		}
		
		
	}
}
