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
        ITestApi2  testApi1 =  applicationContext.getBean("testApi1", ITestApi2.class);
        testApi1.test();
        ITestApi2  testApi2 =  applicationContext.getBean("testApi2", ITestApi2.class);
        testApi2.test();

        ITestApi2  testApi3 =  applicationContext.getBean("testApi3", ITestApi2.class);
        testApi3.test();

        ITestApi2  testApi4 =  applicationContext.getBean("testApi4", ITestApi2.class);
        testApi4.test();
	}

}
