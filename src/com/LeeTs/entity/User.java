package com.LeeTs.entity;

public class User {
	private int userid;
	private String name;
	private int deptid;
	private String birth;
	
	public User() {
		super();
	}
	public User(String name, int deptid, String birth) {
		super();
		this.name = name;
		this.deptid = deptid;
		this.birth = birth;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", deptid=" + deptid + ", birth=" + birth
				+ "]";
	}
	
	
}
