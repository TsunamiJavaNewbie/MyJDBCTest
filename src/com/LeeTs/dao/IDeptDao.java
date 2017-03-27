package com.LeeTs.dao;

import java.util.List;

import com.LeeTs.entity.Dept;

/**
 * 
 * @author Ts_Lee 部门表数据访问接口
 */
public interface IDeptDao {
	/**
	 * 查找全部部门
	 * 
	 * @return
	 */
	List<Dept> queryAll();
}
