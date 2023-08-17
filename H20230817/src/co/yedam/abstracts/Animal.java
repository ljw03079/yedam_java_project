package co.yedam.abstracts;

public abstract class Animal {
	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	//추상메소드 -> 구현부분이 없음
	public abstract void sound(); //자식클래스에서 반드시 구현해야함
}
