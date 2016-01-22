package com.alvin.myhealth.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvin.myhealth.user.dao.UserDao;
import com.alvin.myhealth.user.model.UserInfo;

@Service("UserService")
public class UserService {
	@Autowired
	private UserDao userManager;


	/**
	 * 验证是否存在用户名
	 * 
	 * @param userName
	 * @return
	 */
	public UserInfo verifyPhone(String phone) {
		return userManager.selectUserInfo(phone);
	}
	
	/**
	 * 验证用户和密码
	 * @param userInfo
	 * @return
	 */
	public UserInfo selectUserInfo(UserInfo userInfo)
	{
		return userManager.selectUserInfo(userInfo);
	}
	
	
	/**
	 * 插入用户信息
	 * @param userInfo
	 */
	public void insertUserInfo(UserInfo userInfo)
	{
		userManager.insertUserInfo(userInfo);
	}
	
}
