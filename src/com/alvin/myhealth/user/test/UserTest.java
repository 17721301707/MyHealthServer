package com.alvin.myhealth.user.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alvin.myhealth.core.util.UtilTime;
import com.alvin.myhealth.user.model.UserInfo;
import com.alvin.myhealth.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/testConfig.xml")
// º”‘ÿ≈‰÷√
public class UserTest {
	@Autowired
	private UserService service;
	@Test
	public void login() {
		UserInfo userInfo = new UserInfo();
		userInfo.setPhone("17721301707");
		userInfo.setPassword("123456");
		UserInfo result = service.selectUserInfo(userInfo);
		if (result!=null) {
			System.out.println("YES " + result.getPhone());
		} else {
			System.out.println("NO ");
		}
	}
	
	@Test
	public void insert(){
		UserInfo userInfo = new UserInfo();
		userInfo.setPhone("18051097429");
		userInfo.setPassword("654321");
		userInfo.setCreatetime(UtilTime.getCurrentDateTime());
		
		try {
			service.insertUserInfo(userInfo);
			System.out.println("Insert Success");
		} catch (Exception e) {
			System.out.println("Insert Fail");
			e.printStackTrace();
		}
	}
}
