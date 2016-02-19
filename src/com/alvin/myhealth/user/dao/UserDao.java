package com.alvin.myhealth.user.dao;

import org.springframework.stereotype.Component;

import com.alvin.myhealth.core.model.BaseDao;
import com.alvin.myhealth.user.model.UserInfo;


@Component("UserDao")
public class UserDao extends BaseDao{
	/**
	 * @param phone
	 * @return
	 */
	public UserInfo selectUserInfo(String phone)
	{
		return this.writerSqlSession.selectOne("com.alvin.myhealth.user.dao.UserDao.selectUserInfoByPhone",phone);		
	}
	
	/**
	 * @param userInfo
	 * @return
	 */
	public UserInfo selectUserInfo(UserInfo userInfo)
	{
		return this.writerSqlSession.selectOne("com.alvin.myhealth.user.dao.UserDao.selectUserInfoByPhonePw",userInfo);
	}
	
	/**
	 * @param userInfo
	 * @return
	 */
	public void insertUserInfo(UserInfo userInfo)
	{
		this.writerSqlSession.selectOne("com.alvin.myhealth.user.dao.UserDao.insertUser",userInfo);
	}
}
