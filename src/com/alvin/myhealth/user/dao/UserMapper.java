package com.alvin.myhealth.user.dao;

import org.springframework.stereotype.Repository;

import com.alvin.myhealth.user.model.User;

@Repository
public interface UserMapper {
	/**
	 * 检查用户名是否存在
	 * @param userName
	 * @return
	 */
	public User selectUserInfoByUserName(String userName) ;
}
