package com.alvin.myhealth.weixin.test;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alvin.myhealth.weixin.model.Message;
import com.alvin.myhealth.weixin.service.WeixinService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/testConfig.xml")
public class WeixinTest {
	@Resource(name = "weixinService")
	private WeixinService weixinService;
	@Test
	public void MessageInsert()
	{
		Message msg = new Message();
		msg.setContent("hhh");
		msg.setDescription("llll");
		try {
			weixinService.addMessage(msg);
			System.out.println("Insert Success");
		} catch (Exception e) {
			System.out.println("Insert Fail");
			e.printStackTrace();
		}
	}
}
