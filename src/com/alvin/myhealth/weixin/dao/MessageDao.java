package com.alvin.myhealth.weixin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alvin.myhealth.core.model.BaseDao;
import com.alvin.myhealth.weixin.model.Message;


@Component("messageDao")
public class MessageDao extends BaseDao{
	public int addMessage(Message message) {
		return this.writerSqlSession.insert("com.alvin.myhealth.weixin.dao.MessageDao.addMessage", message);
	}
	
	public List<Message> findMessage(int start,int size) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("start", start);
		map.put("size", size);
		return this.writerSqlSession.selectList("com.alvin.myhealth.weixin.dao.MessageDao.selectMessage",map);
	}
}
