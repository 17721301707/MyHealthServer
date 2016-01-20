package com.alvin.myhealth.user.dao;

import org.springframework.stereotype.Component;

import com.alvin.myhealth.core.model.BaseDao;
import com.alvin.myhealth.user.model.User;


@Component("UserDao")
public class UserDao extends BaseDao{
	/**
	 * 检查用户名是否存在
	 * @param userName
	 * @return
	 */
	public User selectUserInfo(String userName)
	{
		return this.writerSqlSession.selectOne("com.alvin.myhealth.user.dao.UserDao.selectUserInfoByUserName",userName);
	}
}
