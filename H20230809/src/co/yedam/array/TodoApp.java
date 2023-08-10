package co.yedam.array;

public class TodoApp {
	public static void main(String[] args) {
		//등록/완료/조회(날짜)/미완료/
		//등록: 1(가능하면 자동계산) 할일 0812 이런 형태로 등록
		//완료: 1 2 4 이런 형태로 입력 후 엔터 -> 1,2,4의 상태를 바꿔주도록
		//조회(날짜): 0812 -> 입력하면 0812 해당되는 목록 다 출력, 없으면 없다고 출력 
		//미완료: -> 미완료 목록 출력 / 순번 1,2,4,3,6,5를 넣으면 순번기준으로 목록을 정렬
		
		sortSample();
	}
	public static void sortSample() { //배열 정렬
		int[] intAry = {45,23,90,77,12,8}; 
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
