package co.yedam.friend;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String phone;
	private Date birth;//1998-08-05 -> SimpleDateFormat이 가지고 있는 parse 메소드 사용 sdf.parse("1998-08-05");
	
	public Friend(String name, String phone, Date birth) {
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
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//출력하기 위한 용도
		return "Friend [name=" + name + ", phone=" + phone + ", birth=" + sdf.format(birth) + "]";
	}
	
	
}
