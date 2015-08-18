package com.framework.ioc.autowire;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 构造器注入
 */
public class TestBeanAutoWireByCons {

	private String msg;

	@Autowired(required = false)
	public TestBeanAutoWireByCons(String msg) {
		this.msg = msg;
	}

	public String getmsg() {
		return msg;
	}

	/*public void setMessage(String message) {
		this.message = message;
	}*/
}
