package com.framework.ioc.test;

import com.framework.ioc.test.impl.TestImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * =========================== 维护日志 ===========================
 * 2015-08-04 19:30  kongming 新建代码 
 * =========================== 维护日志 ===========================
 */
public class SpringIOCTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
		ITestApi iTestApi = applicationContext.getBean("test", TestImpl.class);
		iTestApi.hello();
	}

}
