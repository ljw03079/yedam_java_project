package co.yedam.generic;

import java.util.ArrayList;
import java.util.List;

public class ListExe2 {
	public static void main(String[] args) {
		List<Member> list = new ArrayList<Member>();
		list.add(new Member(1001,"Hong"));
		Member member = new Member(1002, "Hwang");
		list.add(member);
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMemberId()==1001) {
//				list.get(i).setMemberName("홍");
				list.remove(i); //배열은 null값을 넣어줬음
			}
		}
		
		for(Member mem : list) {
			System.out.printf("이름은 %s\n", mem.getMemberName());
		}
	}
}
