package com.alvin.myhealth.core.model;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

public class BaseDao {
	@Resource(name="writerSqlSession")
	public SqlSessionTemplate writerSqlSession;
}
