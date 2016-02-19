package com.alvin.myhealth.heart.dao;

import org.springframework.stereotype.Component;

import com.alvin.myhealth.core.model.BaseDao;
import com.alvin.myhealth.heart.model.HeartBeat;

@Component("HeartBeatDao")
public class HeartBeatDao extends BaseDao {
	public void insertUserInfo(HeartBeat heartbeat) {
		this.writerSqlSession.selectOne(
				"com.alvin.myhealth.heart.dao.HeartBeatDao.insertBeat",
				heartbeat);
	}
}
