package co.yedam.api;

import java.lang.reflect.Method;

public class ClassExe {
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("co.yedam.api.Member");//클래스의 정보를 볼 수 있음
			Method[] methods = cls.getDeclaredMethods();//메소드들의 정보를 가져와줌, Method의 배열타입
			for(Method meth : methods) {
				System.out.println(meth.getName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
