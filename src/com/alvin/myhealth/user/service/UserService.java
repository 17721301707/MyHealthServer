package com.alvin.myhealth.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvin.myhealth.core.model.ResultModel;
import com.alvin.myhealth.user.dao.UserDao;
import com.alvin.myhealth.user.model.User;

@Service("UserService")
public class UserService {
	@Autowired
	private UserDao userManager;


	/**
	 * ��֤�Ƿ�����û���
	 * 
	 * @param userName
	 * @return
	 */
	public ResultModel isExistUserInfoByUserName(String userName) {
		User user = userManager.selectUserInfo(userName);
		ResultModel resultModel = new ResultModel();
		if (user != null) {
			resultModel.setFlag(true);
			resultModel.setContent(userName + "���û����Ѵ��ڣ�");
		} else {
			resultModel.setFlag(false);
			resultModel.setContent(userName + "���û�������ʹ�ã�");
		}
		return resultModel;
	}
	
	
}
