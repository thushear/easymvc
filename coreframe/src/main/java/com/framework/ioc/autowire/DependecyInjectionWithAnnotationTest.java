package com.framework.ioc.autowire;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.reflect.misc.ReflectUtil;

import java.util.Arrays;

public class DependecyInjectionWithAnnotationTest {



	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-di-annotation.xml");


	@Test
	public void testRequiredAnno(){
		TestBean testBean =  ctx.getBean("testBean", TestBean.class);
		Assert.assertTrue("message".equals(testBean.getMessage()));
	}

	/**
	 * 俩个以上相同类型bean的时候 会抛出异常
	 * Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'testBeanAwByCons' defined in class path resource [spring-di-annotation.xml]: Unsatisfied dependency expressed through constructor argument with index 0 of type [java.lang.String]: : No unique bean of type [java.lang.String] is defined: expected single matching bean but found 2: [message, message1]; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No unique bean of type [java.lang.String] is defined: expected single matching bean but found 2: [message, message1]
	 *
	 */
	@Test
	public void testAutoWireByConstructor(){
		String message =  ctx.getBean("message",String.class);
		TestBeanAutoWireByCons testBeanAutoWireByCons = ctx.getBean("testBeanAwByCons",TestBeanAutoWireByCons.class);
		System.out.println("message:" + testBeanAutoWireByCons.getmsg());
		Assert.assertEquals(message,testBeanAutoWireByCons.getmsg());
	}

	/**
	 * autoWired默认是按照ByType来装配的,所以当同一类型的Bean在spring中
	 * 存在俩个以上时会抛出异常
	 * Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'testBeanAwByCons' defined in class path resource [spring-di-annotation.xml]: Unsatisfied dependency expressed through constructor argument with index 0 of type [java.lang.String]: : No unique bean of type [java.lang.String] is defined: expected single matching bean but found 2: [message, message1]; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No unique bean of type [java.lang.String] is defined: expected single matching bean but found 2: [message, message1]
	 *
	 */
	@Test
	public void testAutoWiredByField(){
		TestBeanAutoWireByField testBeanAutoWireByField =  ctx.getBean("testBeanAwByField", TestBeanAutoWireByField.class);
		System.out.println("text :" + testBeanAutoWireByField.getText());

	}


	@Test
	public void testAutoWireByMethod(){
		TestBeanAutoWireByMethod testBeanAutoWireByMethod =  ctx.getBean("testBeanAwByMethod", TestBeanAutoWireByMethod.class);
		System.out.println(testBeanAutoWireByMethod.getList() + " : " + testBeanAutoWireByMethod.getMessage());
		Assert.assertEquals(ctx.getBean("list"),testBeanAutoWireByMethod.getList());
	}

	@Test
	public void testQualifier1(){
		TestBeanQualifier1 testBeanQualifier1 =  ctx.getBean("testBeanQualifier1", TestBeanQualifier1.class);
		System.out.println(testBeanQualifier1.getL());
	}


	@Test
	public void testQualifier2(){
		TestBeanQualifier2 testBeanQualifier2 =  ctx.getBean("testBeanQualifier2", TestBeanQualifier2.class);

		try {
			ctx.getBean("mySqlDataSource");
			Assert.fail("should not reach here");
		} catch (BeansException e) {
			e.printStackTrace();
			Assert.assertTrue(e instanceof NoSuchBeanDefinitionException);

		}

		Assert.assertEquals(ctx.getBean("mySqlDataSourceBean") , testBeanQualifier2.getDataSource());
	}


	@Test
	public void testResourceInject(){
		TestBeanInjectByResource testBeanInjectByResource =  ctx.getBean("testBeanInjectByResource", TestBeanInjectByResource.class);
		System.out.println(testBeanInjectByResource.getMessage() + ": " + testBeanInjectByResource.getL());

	}

}
