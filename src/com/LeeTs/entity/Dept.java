package com.LeeTs.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Dept implements Serializable {
	private int deptid;
	private String deptname;

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dept(int deptid, String deptname) {
		super();
		this.deptid = deptid;
		this.deptname = deptname;
	}

	public Dept(int deptid) {
		super();
		this.deptid = deptid;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.deptname;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime = 31;
		int result = 1;
		result = prime * result + deptid;
		result = prime * result
				+ ((deptname == null) ? 0 : deptname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Dept dept = (Dept) obj;
		return dept.getDeptid() == this.getDeptid();
	}
}
