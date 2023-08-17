package co.yedam.friend;

public class Friend {
	private String name;
	private String phone;
	
	public Friend(String name, String phone){
		this.name = name;
		this.phone = phone;
	}
	
	//getter, setter
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	public String showInfo() {
		return "이름은 " + name + ", 연락처는 " + phone;
	}
}
/* 친구연락처 정보
 * 
 * 학교친구 -- 이름, 연락처, 학교, 전공
 * 회사친구 -- 이름, 연락처, 회사, 부서 
 * 친구 -- 이름, 연락처 
 * 
 * Friend - 이름, 연락처
 * UnivFriend - 학교, 전공 
 * CompFriend - 회사, 부서 
 * FriendApp - CRUD(create, read, update, delete)
 * MainExe - main 클래스 */