package co.yedam.generic;

import java.util.LinkedList;
import java.util.Queue;

//Que: FirstInFirstOut(FIFO) -> 먼저 들어간 값이 먼저 나오는 구조, 컬랙션
public class QueExe {
	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>();// 큐는 linkedlist가 구조
		que.offer("One");
		que.offer("Two");
		que.offer("Three");

		while (!que.isEmpty()) {
			String val = que.poll();
			System.out.println(val);
		}
	}
}
