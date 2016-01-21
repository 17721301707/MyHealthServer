package com.alvin.myhealth.user.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alvin.myhealth.user.model.UserInfo;
import com.alvin.myhealth.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/app-config.xml")
// º”‘ÿ≈‰÷√
public class UserTest {
	@Autowired
	private UserService service;
	@Test
	public void login() {
		UserInfo userInfo = new UserInfo();
		userInfo.setPhone("17721301707");
		userInfo.setPassword("123456");
		UserInfo result = service.login(userInfo);
		if (result!=null) {
			System.out.println("YES " + result.getPhone());
		} else {
			System.out.println("NO ");
		}
	}
}
