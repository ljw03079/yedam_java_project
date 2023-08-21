package co.yedam.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExe {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();//List 인터페이스를 구현하는 클래스
		long start = System.currentTimeMillis();
		for(int i=0; i<100000; i++) {
			list.add(0, ""+i);
		}
		long end = System.currentTimeMillis();
		System.out.println("ArrayList: "+(end-start)+" ms");
		
		list = new LinkedList<>();//제일 뒤에 추가하는 건 arraylist보다 시간이 더 걸림, 중간에 추가하는 건 linkedlist가 더 빠름
		start = System.currentTimeMillis();
		for(int i=0; i<100000; i++) {
			list.add(0, ""+i);//중간에 추가
		}
		end = System.currentTimeMillis();
		System.out.println("ArrayList: "+(end-start)+" ms");
		
		//멀티스레드할때 vector 안전, 쓰는 방법은 arraylist, linkedlist, vector 같음
	}
}
