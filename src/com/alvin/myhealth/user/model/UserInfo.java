package com.alvin.myhealth.user.model;

import com.alvin.myhealth.core.model.BaseEntity;

public class UserInfo extends BaseEntity {
	private static final long serialVersionUID = -7411941378718752278L;
	/*
	 * �ֻ���
	 */
	private String phone;
	/*
	 * ����
	 */
	private String password;
	/*
	 * ����ʱ��
	 */
	private String createtime;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	
}
