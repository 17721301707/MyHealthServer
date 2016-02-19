package com.alvin.myhealth.heart.model;

import org.springframework.stereotype.Component;

import com.alvin.myhealth.core.model.BaseDao;

@Component("HeartBeat")
public class HeartBeat extends BaseDao {
	private String phone;
	private float beat;
	private int mode;
	private String testtime;
	private String createtime;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public float getBeat() {
		return beat;
	}

	public void setBeat(float beat) {
		this.beat = beat;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public String getTesttime() {
		return testtime;
	}

	public void setTesttime(String testtime) {
		this.testtime = testtime;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

}
