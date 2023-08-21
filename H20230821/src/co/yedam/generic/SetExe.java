package co.yedam.generic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();//Set: 인터페이스
		set.add("홍길동");
		set.add("김길동");
		set.add("박길동");
		set.add("홍길동");//동일값은 저장안됨, set.size():3
		//set.remove("홍길동");
		
		set.iterator();//반복자: 객체를 가리키는 지팡이
		Iterator<String> iter = set.iterator();//반복자를 통해 루핀돌면서 가지고옴
		while(iter.hasNext()) {//hasNext(): 끄집어낼 요소가 있으면 true, 없으면 false
			String val = iter.next();//컬렉션에서 객체를 하나 가져옴
			System.out.println(val);
		}
		
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(11);//중복값 저장됨
		
		Set<Integer> iset = new HashSet<>();
		for(Integer no : list) {
			iset.add(no);
		}
		
		for(Integer no : iset) {
			System.out.println(no);
		}
	}
}
