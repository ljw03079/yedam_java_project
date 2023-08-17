package co.yedam.inheritance;

public class CellPhone extends Object{
	private String model;
	private String color;
	
	CellPhone(){}
	
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();//모든클래스는 Object(최상위클래스)를 상속받음
		return color + ", " + model;
	}
}
