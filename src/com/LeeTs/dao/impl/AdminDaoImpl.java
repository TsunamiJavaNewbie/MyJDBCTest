package com.LeeTs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.LeeTs.dao.IAdminDao;
import com.LeeTs.entity.Admin;
import com.LeeTs.util.DBConnection;

public class AdminDaoImpl implements IAdminDao {
	DBConnection util = new DBConnection();

	@Override
	public Admin QueryByUsername(String username) {
		return _adminPassword(util.query(
				"select * from admins where username=?", username));
	}

	private Admin _adminPassword(ResultSet rs) {
		Admin admin = null;
		try {
			if (rs.next()) {
				admin = new Admin();
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("username"));
				System.out.println(admin.getName()+":"+admin.getPassword());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.clossAll();
		}
		return admin;

	}

}
