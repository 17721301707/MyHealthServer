package com.alvin.myhealth.heart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvin.myhealth.heart.dao.HeartBeatDao;
import com.alvin.myhealth.heart.model.HeartBeat;

@Service("HeartBeatService")
public class HeartBeatService {
	@Autowired
	private HeartBeatDao heartBeatManager;

	public void insertBeat(HeartBeat heartBeat) {
		heartBeatManager.insertUserInfo(heartBeat);
	}
}
