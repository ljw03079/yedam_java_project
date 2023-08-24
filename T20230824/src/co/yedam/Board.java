package co.yedam;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board implements Serializable {
	//필드
	private int brdNo;
	private String brdTitle;
	private String brdContent;
	private String brdWriter;
	private Date brdWriteDate;
	//생성자
	public Board(){}
	public Board(int brdNo, String brdTitle, String brdContent, String brdWriter, Date brdWriteDate) {
		super();
		this.brdNo = brdNo;
		this.brdTitle = brdTitle;
		this.brdContent = brdContent;
		this.brdWriter = brdWriter;
		this.brdWriteDate = brdWriteDate;
	}
	//메소드
	public int getBrdNo() {
		return brdNo;
	}
	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}
	public String getBrdTitle() {
		return brdTitle;
	}
	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}
	public String getBrdContent() {
		return brdContent;
	}
	public void setBrdContent(String brdContent) {
		this.brdContent = brdContent;
	}
	public String getBrdWriter() {
		return brdWriter;
	}
	public void setBrdWriter(String brdWriter) {
		this.brdWriter = brdWriter;
	}
	public Date getBrdWriteDate() {
		return brdWriteDate;
	}
	public void setBrdWriteDate(Date brdWriteDate) {
		this.brdWriteDate = brdWriteDate;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return " 글번호: [" + brdNo + "], 글제목: " + brdTitle + "\n 글내용: " + brdContent + "\n 작성자: "
				+ brdWriter + ", 작성일시: " + sdf.format(brdWriteDate);
	}
}
