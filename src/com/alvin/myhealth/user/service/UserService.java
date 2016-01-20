package com.alvin.myhealth.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvin.myhealth.core.model.ResultModel;
import com.alvin.myhealth.user.dao.UserMapper;
import com.alvin.myhealth.user.model.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userManager;


	/**
	 * 验证是否存在用户名
	 * 
	 * @param userName
	 * @return
	 */
	public ResultModel isExistUserInfoByUserName(String userName) {
		User user = userManager.selectUserInfoByUserName(userName);
		ResultModel resultModel = new ResultModel();
		if (user != null) {
			resultModel.setFlag(true);
			resultModel.setContent(userName + "该用户名已存在！");
		} else {
			resultModel.setFlag(false);
			resultModel.setContent(userName + "该用户名可以使用！");
		}
		return resultModel;
	}
	
	
}
