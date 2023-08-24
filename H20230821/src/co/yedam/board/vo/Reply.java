package co.yedam.board.vo;

import java.io.Serializable;

public class Reply implements Serializable{
	int rpNo;
	int brdNo;
	String rpContent;
	String rpWriter;
	public Reply(){}
	public Reply(int brdNo, String rpContent, String rpWriter) {
		super();
		this.brdNo = brdNo;
		this.rpContent = rpContent;
		this.rpWriter = rpWriter;
	}

	public int getRpNo() {
		return rpNo;
	}

	public void setRpNo(int rpNo) {
		this.rpNo = rpNo;
	}

	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getRpContent() {
		return rpContent;
	}

	public void setRpContent(String rpContent) {
		this.rpContent = rpContent;
	}

	public String getRpWriter() {
		return rpWriter;
	}

	public void setRpWriter(String rpWriter) {
		this.rpWriter = rpWriter;
	}

	public String showInfo() {
		return "댓글번호: " + rpNo + ", 원본글번호: "+brdNo+", 댓글내용: " + rpContent + ", 댓글작성자: " + rpWriter+
				"\n------------------------------------------------------------";
	}
	
}
