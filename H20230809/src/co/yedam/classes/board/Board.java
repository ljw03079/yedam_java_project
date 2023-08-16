package co.yedam.classes.board;

public class Board {
	//필드
	private int borNo;
	private String borTit;
	private String borWri;
	private String borCon;
	//생성자
	Board(){};
	public Board(String borTit, String borWri, String borCon) {
		super();
		this.borTit = borTit;
		this.borWri = borWri;
		this.borCon = borCon;
	}
	//메소드
	public int getBorNo() {
		return borNo;
	}
	public void setBorNo(int borNo) {
		this.borNo = borNo;
	}
	public String getBorTit() {
		return borTit;
	}
	public void setBorTit(String borTit) {
		this.borTit = borTit;
	}
	public String getBorWri() {
		return borWri;
	}
	public void setBorWri(String borWri) {
		this.borWri = borWri;
	}
	public String getBorCon() {
		return borCon;
	}
	public void setBorCon(String borCon) {
		this.borCon = borCon;
	}
}
