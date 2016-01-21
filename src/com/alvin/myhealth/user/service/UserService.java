package com.alvin.myhealth.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvin.myhealth.core.model.ResultModel;
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
	public ResultModel verifyPhone(String phone) {
		UserInfo user = userManager.selectUserInfo(phone);
		ResultModel resultModel = new ResultModel();
		if (user != null) {
			resultModel.setFlag(true);
			resultModel.setContent(phone + "该手机存在");
		} else {
			resultModel.setFlag(false);
			resultModel.setContent(phone + "该手机不存在");
		}
		return resultModel;
	}
	
	/**
	 * 登录
	 * @param userInfo
	 * @return
	 */
	public UserInfo login(UserInfo userInfo)
	{
		return userManager.login(userInfo);
	}
	
	
}
