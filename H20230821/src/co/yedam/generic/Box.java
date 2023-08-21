package co.yedam.generic;

//T: type parameter
//<T> 제네릭
public class Box<T> {
	//Object obj;//Object 하위 클래스 다 담을 수 있음
	T obj;//Box 클래스 사용하는 시점에 타입을 정하겠다는 의미: 제네릭, 대문자
	
	T get() {
		return obj;
	}
	
	void set(T obj) {
		this.obj = obj;
	}
}
