package com.framework.ioc.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;

public class TestBeanQualifier2 {

	private DataSource dataSource;


	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(@Qualifier("mySqlDataSource") DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
