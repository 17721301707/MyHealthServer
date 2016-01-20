package com.alvin.myhealth.user.dao;

import org.springframework.stereotype.Repository;

import com.alvin.myhealth.user.model.User;

@Repository
public interface UserMapper {
	/**
	 * ����û����Ƿ����
	 * @param userName
	 * @return
	 */
	public User selectUserInfoByUserName(String userName) ;
}
