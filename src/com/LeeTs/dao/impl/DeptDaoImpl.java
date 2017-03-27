package com.LeeTs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.LeeTs.dao.IDeptDao;
import com.LeeTs.entity.Dept;
import com.LeeTs.util.DBConnection;

public class DeptDaoImpl implements IDeptDao {
	DBConnection util = new DBConnection();

	@Override
	public List<Dept> queryAll() {
		// TODO Auto-generated method stub
		return _list(util.query("select * from dept"));
	}

	private List<Dept> _list(ResultSet rs) {
		List<Dept> _list = new ArrayList<Dept>();
		try {
			while (rs.next()) {
				Dept dept = new Dept();
				dept.setDeptid(rs.getInt("dept"));
				dept.setDeptname(rs.getString("deptname"));
				_list.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.clossAll();
		}
		return _list;
	}

}
