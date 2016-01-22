package com.alvin.myhealth.core.model;

public class ResultModel extends BaseEntity {
	private static final long serialVersionUID = 9014816928447619351L;
	/**
	 * ����״̬�ɹ� ʧ��
	 */
	private Boolean flag;

	/**
	 * ���ز�������
	 */
	private String content;

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "flag->" + flag + "content->" + content;
	}

}
