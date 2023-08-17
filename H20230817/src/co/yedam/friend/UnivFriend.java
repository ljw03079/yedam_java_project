package co.yedam.friend;

public class UnivFriend extends Friend{ //기본생성자가 없어서 에러, 부모 클래스에도 기본생성자가 없음
	private String univ;
	private String major;
	
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone); //부모생성자
		this.univ = univ;
		this.major = major;
	}

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
		public String showInfo() {
			// TODO Auto-generated method stub
			return super.showInfo() + ", 학교는 " + univ + ", 전공은 " + major;
		}
}
