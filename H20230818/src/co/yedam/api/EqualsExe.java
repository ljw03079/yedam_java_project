package co.yedam.api;

class Member{
	private int memberId;
	private String memberName;
	
	public Member(int memberId, String memberName) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	
	@Override
	public String toString() {
		//return super.toString();
		return "Member [memberId=" + memberId + ", memberName=" + memberName + "]";
	}


	@Override
	public int hashCode() { //Object클래스가 가지고 있는 hashCode, 16진수 주소값
		// TODO Auto-generated method stub
		return memberId;
	}
	@Override
	public boolean equals(Object obj) {//Object클래스가 가지고 있는 equals, 논리적 비교
		//return super.equals(obj);//부모클래스: Object
		Member target = (Member) obj;//매개값이 Object타입이므로 Member타입으로 캐스팅해줌
		if(this.memberId == target.memberId && this.memberName.equals(target.memberName)) {
			return true; //논리적 동일객체로 정의
		} else {
			return false;
		}
		
	}
	
}
public class EqualsExe {
	public static void main(String[] args) {
		String str1 = new String("Hong");
		String str2 = new String("Hong");
		
		Member mem1 = new Member(101,"Hong");
		Member mem2 = new Member(101,"Hwang");
		
		System.out.println(str1 == str2);//주소값 비교, 객체 따로 만들어짐, 물리적
		System.out.println(str1.equals(str2));//문자 비교, 논리적
		
//		Member mem1 = new Member();
//		Member mem2 = new Member();
		System.out.println(mem1.equals(mem2));
	}
}
