package com.alvin.myhealth.user.model;

import com.alvin.myhealth.core.model.BaseEntity;

public class User extends BaseEntity {
	private static final long serialVersionUID = -7411941378718752278L;
	/*
	 * ÊÖ»úºÅ
	 */
	private String phone;
	/*
	 * ÃÜÂë
	 */
	private String password;

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

}
