package com.framework.ioc.autowire;

import org.springframework.beans.factory.annotation.Required;

public class TestBean {

	private String message;

	public String getMessage() {
		return message;
	}

	@Required
	public void setMessage(String message) {
		this.message = message;
	}
}
