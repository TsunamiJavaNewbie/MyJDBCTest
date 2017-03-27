package com.LeeTs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Ts_Lee 数据库连接工具辅助类
 */
public class DBConnection {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/testsystems";
	public static final String USER = "root";
	public static final String PWD = "mysql";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public DBConnection() {
		try {
			// 加载驱动程序
			Class.forName(DRIVER);
			// System.out.println("加载驱动成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回数据库连接
	 */
	public Connection getConn() {
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			// System.out.println("成功连接数据库！");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭资源 ,按顺序关闭资源
	 */
	public void clossAll() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// System.out.println("关闭数据库");
	}

	/**
	 * @param sql
	 *            输入的sql语句
	 * @param pras
	 *            参数列表
	 * @return 受影响的条数
	 */
	public int update(String sql, Object... pras) {
		int res = 0;
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			if (pras != null) {
				for (int i = 0; i < pras.length; i++) {
					ps.setObject(i + 1, pras[i]);
				}
			}
			res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll();
		}
		return res;
	}

	/**
	 * 
	 * @param sql
	 *            sql语句
	 * @param pras
	 * @return 结果集
	 */
	public ResultSet query(String sql, Object... pras) {
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			if (pras != null) {
				for (int i = 0; i < pras.length; i++) {
					ps.setObject(i + 1, pras[i]);
				}
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
