package com.alvin.myhealth.weixin.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alvin.myhealth.weixin.dao.MessageDao;
import com.alvin.myhealth.weixin.model.Message;


@Service("weixinService")
public class WeixinService {
	@Resource(name="messageDao")
	private MessageDao messageDao;
	
	/**
	 * 新增Message对象到数据库中
	 */
	public void addMessage(Message message) {
		messageDao.addMessage(message);
	}
}
