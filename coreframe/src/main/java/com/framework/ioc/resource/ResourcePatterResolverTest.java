package com.framework.ioc.resource;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

public class ResourcePatterResolverTest {

	@Test
	public void testClassPathPatternResolverTest() throws IOException {
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resourcePatternResolver.getResources("classpath:META-INF/INDEX.LIST");
		System.out.println(ArrayUtils.toString(resources));
		Resource[] resources1 = resourcePatternResolver.getResources("classpath:META-INF/*.LIST");
		System.out.println(ArrayUtils.toString(resources1));
	}


	@Test
	public void testClasspathAsteriskPrefix() throws IOException {
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resourcePatternResolver.getResources("classpath*:META-INF/INDEX.LIST");
		System.out.println(ArrayUtils.toString(resources));
	}


	@Test
	public void testFilePrefix() throws IOException {
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resourcePatternResolver.getResources("file:D:/*.*");
		System.out.println(ArrayUtils.toString(resources));
	}


	@Test
	public void testApplicationContext(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext();

	}


}
