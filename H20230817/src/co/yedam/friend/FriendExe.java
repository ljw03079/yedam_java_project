package co.yedam.friend;

public class FriendExe {
	public static void main(String[] args) {
		// name, phone
		String name;
		String phone;
		
		// 배열[5] 선언
		Friend[] friends = new Friend[5];

		friends[0] = new Friend("hong", "010-1111");
		friends[1] = new Friend("hwang", "010-2222");
		friends[2] = new Friend("kim", "010-3333");
		
		name = "hong";
		phone = "010-1111";
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && friends[i].getName().equals(name)) {
				System.out.println(friends[i].showInfo());
			}
		}
		
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && friends[i].getName().equals(name)) {
				friends[i].setPhone(phone);
			}
		}
	}
}
