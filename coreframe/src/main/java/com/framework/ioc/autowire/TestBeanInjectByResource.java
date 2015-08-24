package com.framework.ioc.autowire;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * JSR-250 common annotation 注解支持
 */
public class TestBeanInjectByResource {

	@Resource
	private String message;

	@Resource(name = "long2")
	private Long l;


	@PostConstruct
	public void init(){
		System.out.println("--------@PostConstruct  do ----------- " + this.toString());
	}

	@PreDestroy
	public void destroy(){
		System.out.println("--------@@PreDestroy  do -----------" + toString());
	}

	public Long getL() {
		return l;
	}

	public void setL(Long l) {
		this.l = l;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("TestBeanInjectByResource{");
		sb.append("message='").append(message).append('\'');
		sb.append(", l=").append(l);
		sb.append('}');
		return sb.toString();
	}
}
