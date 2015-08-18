package com.framework.ioc.autowire;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * 根据方法自动装配
 */
public class TestBeanAutoWireByMethod {

	private String message;

	private ArrayList list;


	//根据方法自动装配
	@Autowired
	public void init(String message, ArrayList list) {
		this.message = message;
		this.list = list;
	}

	public String getMessage() {
		return message;
	}

	public ArrayList getList() {
		return list;
	}
}
