package com.framework.ioc.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 测试 Qualifier
 */
public class TestBeanQualifier1 {

	@Autowired
	@Qualifier("long2")  //通过Qualifier 的 value 来限定 具体的bean
	private Long l;

	public Long getL() {
		return l;
	}
}
