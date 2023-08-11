package co.yedam.classes.friend;

import java.util.Date;

public class Friend extends Object{ //모든 클래스는 기본적으로 Object 클래스를 상속받음
	private /*final*/ String name;
	private String phone;
//	private Date birth;
	private String birth;
	
//	public Friend(String name, String phone, Date birth) {
//		super(); //부모클래스를 가리킴, 지금은 있어도 되고 없어도 됨
//		this.name = name;
//		this.phone = phone;
//		this.birth = birth;
//	}

	public Friend(String name, String phone, String birth) {
		super();
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override 
	//-> 부모가 가지고 있는 메소드를 재정의, 오버라이드가 안되면 주소값
	public String toString() {
		return "Friend [name=" + name + ", phone=" + phone + ", birth=" + birth + "]";
	}

	
	
}
