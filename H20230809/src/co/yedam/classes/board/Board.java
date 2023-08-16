package co.yedam.classes.board;

public class Board {
	private int borNo;
	private String borTitle;
	private String borWriter;
	private String borContent;
	Board(){}
	
	public Board(String borTitle, String borWriter, String borContent) {
		this.borTitle = borTitle;
		this.borWriter = borWriter;
		this.borContent = borContent;
	}

	public int getBorNo() {
		return borNo;
	}

	public void setBorNo(int borNo) {
		this.borNo = borNo;
	}

	public String getBorTitle() {
		return borTitle;
	}

	public void setBorTitle(String borTitle) {
		this.borTitle = borTitle;
	}

	public String getBorWriter() {
		return borWriter;
	}

	public void setBorWriter(String borWriter) {
		this.borWriter = borWriter;
	}

	public String getBorContent() {
		return borContent;
	}

	public void setBorContent(String borContent) {
		this.borContent = borContent;
	}

	@Override
	public String toString() {
		return borNo+"\t\t"+borTitle+"\t"+borWriter;
	}

}
