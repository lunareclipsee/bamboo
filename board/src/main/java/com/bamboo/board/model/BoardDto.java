package com.bamboo.board.model;

import java.util.Date;

public class BoardDto {
	
	private int idx;
	private String title;
	private String content;
	private int password;
	private String inip;
	private Date indate;
	
	public BoardDto() {
		super();
	}

	public BoardDto(int idx, String title, String content, int password, String inip, Date indate) {
		super();
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.password = password;
		this.inip = inip;
		this.indate = indate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getInip() {
		return inip;
	}

	public void setInip(String inip) {
		this.inip = inip;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "BoardDto [idx=" + idx + ", title=" + title + ", content=" + content + ", password=" + password
				+ ", inip=" + inip + ", indate=" + indate + "]";
	}

}
