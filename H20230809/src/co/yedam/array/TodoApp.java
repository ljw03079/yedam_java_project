package co.yedam.array;

import java.util.Scanner;

public class TodoApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		Todo[] todos = new Todo[5];
		int idx = 0;
		String[] data = null;
		String[] data2 = null;
		String[] data3 = null;
		//등록/완료/조회(날짜)/미완료/

		while(run) {
			System.out.println("--------------------------------");
			System.out.println("1.등록 2.완료 3.조회 4.미완료");
			System.out.println("--------------------------------");
			System.out.print("선택>>");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1: //등록: 1(가능하면 자동계산) 할일 0812 이런 형태로 등록
				for(int i=0; i<todos.length; i++) {
					System.out.print("할 일 <공백> 마감기한(ex: 0812)>>");
					data = scn.nextLine().split(" ");
					Todo td = new Todo();
					td.no = i+1;
					td.todo = data[0];
					td.dueDate = data[1];
					td.done = false;
					todos[idx] = td;
					idx++;
				}
				break;
			case 2: //완료: 1 2 4 이런 형태로 입력 후 엔터 -> 1,2,4의 상태를 바꿔주도록
				System.out.print("완료한 항목의 순번>");
				data2 = scn.nextLine().split(" ");
				for(int i=0; i<todos.length; i++) {
					for(int j=0; j<data2.length; j++) {
						if(todos[i].no == Integer.parseInt(data2[j])) {
							todos[i].done = true;
						}
					}
				}
				for(int i=0; i<todos.length; i++) {
					System.out.printf("순번 : %d, 할일: %s, 마감기한: %s, 완료여부: %b \n", todos[i].no, todos[i].todo, todos[i].dueDate, todos[i].done);					
				}
				break;
			case 3: //조회(날짜): 0812 -> 입력하면 0812 해당되는 목록 다 출력, 없으면 없다고 출력 
				System.out.print("조회할 날짜 입력>>");
				data3 = scn.nextLine().split(" ");
				boolean bool = false;
				for(int i=0; i<todos.length; i++) {
					for(int j=0; j<data3.length; j++) {
						if(todos[i].dueDate.equals(data3[j])) {
							System.out.printf("순번: %d, 할일: %s, 마감기한: %s, 완료여부:%b \n",
									todos[i].no, todos[i].todo, todos[i].dueDate, todos[i].done);
							bool = true;
						}						
					}
				}
				if(bool == false) {
					System.out.println("해당되는 목록이 없습니다.");
				}
				break;
			case 4: //미완료: -> 미완료 목록 출력 / 순번 1,2,4,3,6,5를 넣으면 순번기준으로 목록을 정렬
				for(int j=0; j<todos.length-1;j++) {
					for(int i=0; i<todos.length -1; i++) {
						Todo tmp = new Todo();
						if(todos[i].no > todos[i+1].no) {
							tmp = todos[i];
							todos[i]=todos[i+1];
							todos[i+1] = tmp;
						}
					}					
				}
				for(int i=0; i<todos.length; i++) {
					if(!todos[i].done) {
						System.out.printf("순번: %d, 할일: %s, 마감기한: %s, 완료여부:%b \n",
								todos[i].no, todos[i].todo, todos[i].dueDate, todos[i].done);
					}
				}
				break;
			default: 
				run=false; 
			}
		}
		System.out.println("프로그램 종료되었습니다.");
		
		//sortSample();
	}
	public static void sortSample(int[] intAry) { //배열 정렬
		 
		//값 비교해서 큰 값이 뒤로 오게끔...tmp라는 곳에 넣어두고 자리 바꿔주기, 5개의 값이 있으니 4번 반복해서 자리 정렬
		int len = intAry.length-1;
		for(int j=0; j<len; j++) {
			for(int i=0; i < len; i++) {
				if(intAry[i] > intAry[i+1]) {
					int tmp = intAry[i];
					intAry[i] = intAry[i+1];
					intAry[i+1] = tmp;
				}
			}
		}
		for(int num : intAry) {
			System.out.println(num);
		}
	}
}
