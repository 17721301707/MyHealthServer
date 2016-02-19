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
	 * 
	 * @param userName
	 * @return
	 */
	public UserInfo verifyPhone(String phone) {
		return userManager.selectUserInfo(phone);
	}
	
	/**
	 * @param userInfo
	 * @return
	 */
	public UserInfo selectUserInfo(UserInfo userInfo)
	{
		return userManager.selectUserInfo(userInfo);
	}
	
	
	/**
	 * @param userInfo
	 */
	public void insertUserInfo(UserInfo userInfo)
	{
		userManager.insertUserInfo(userInfo);
	}
	
}
