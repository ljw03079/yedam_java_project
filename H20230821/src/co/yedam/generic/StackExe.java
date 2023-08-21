package co.yedam.generic;

import java.util.Stack;

//Stack: LastInFirstOut(LIFO) -> 마지막에 들어간 값이 첫번째로 나오는 구조, 컬랙션
public class StackExe {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("One");
		stack.push("Two");
		stack.push("Three");
		
		while(!stack.isEmpty()) {//true가 될 때까지 루핑
			String val = stack.pop();
			System.out.println(val);			
		}//마지막 이력부터 보고싶을 때 스택 팝 사용
		//제일 첫번째 이력부터 보고싶으면 큐 사용
	}
}
