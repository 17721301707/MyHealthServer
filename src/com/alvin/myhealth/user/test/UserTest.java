package com.alvin.myhealth.user.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alvin.myhealth.core.model.ResultModel;
import com.alvin.myhealth.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/app-config.xml")
// º”‘ÿ≈‰÷√
public class UserTest {
	@Autowired
	private UserService service;
	@Test
	public void login() {
		ResultModel result = service.isExistUserInfoByUserName("17721301707");
		if (result.getFlag()) {
			System.out.println("YES " + result.getContent());
		} else {
			System.out.println("NO " + result.getContent());
		}
	}
}
