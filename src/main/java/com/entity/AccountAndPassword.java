package com.entity;

public class AccountAndPassword {

	private int id;

	private String name;

	private String account;
	
	private String password;
	
	private String extFld;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getExtFld() {
		return extFld;
	}

	public void setExtFld(String extFld) {
		this.extFld = extFld;
	}

}
