package com.entity;

/**
 * <p>Description: 评论实体类</p>
 * @author kangshaofei
 * @date 2016年1月17日
 */
public class Comment {
	private int id;
	private int userId;
	private String comments;
	private String time;
	private String contact;
	private String extFld;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getExtFld() {
		return extFld;
	}
	public void setExtFld(String extFld) {
		this.extFld = extFld;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
