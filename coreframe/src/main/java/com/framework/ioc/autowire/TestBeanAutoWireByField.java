package com.framework.ioc.autowire;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 根据字段来自动装配
 */
public class TestBeanAutoWireByField {

	@Autowired
	private String text;

	public String getText() {
		return text;
	}
}
