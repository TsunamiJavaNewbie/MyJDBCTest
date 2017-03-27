package com.LeeTs.dao;

import com.LeeTs.entity.Admin;

public interface IAdminDao {
	/**
	 * 
	 * @param userid
	 * @return
	 */
	Admin QueryByUsername(String username);

}
