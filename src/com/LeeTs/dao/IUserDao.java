package com.LeeTs.dao;

import java.util.List;

import com.LeeTs.entity.User;

/**
 * 
 * @author Ts_Lee 数据访问接口
 */
public interface IUserDao {
	/**
	 * 添加
	 * 
	 * @param user
	 * @return
	 */
	boolean add(User user);

	/**
	 * 修改
	 * 
	 * @param user
	 * @return
	 */
	boolean update(User user);

	/**
	 * 删除
	 * 
	 * @param userid
	 * @return
	 */
	boolean delete(int userid);

	/**
	 * 通过Id查找一条记录
	 * 
	 * @param userid
	 * @return
	 */
	User QueryById(int userid);

	/**
	 * 查找全部记录
	 * 
	 * @return
	 */
	List<User> queryAll();
}
