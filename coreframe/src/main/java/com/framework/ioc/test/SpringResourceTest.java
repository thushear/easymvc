package com.framework.ioc.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;

/**
 * Created by Administrator on 2015/8/4.
 */
public class SpringResourceTest {


    @Test
    public void testFileResource(){
        Resource  fileResource = new FileSystemResource(new File("src/main/resources/spring-config.xml"));
        BeanFactory beanFactory = new XmlBeanFactory(fileResource);
        ITestApi2  testApi1 =  beanFactory.getBean("testApi1", ITestApi2.class);
        testApi1.test();
    }

    @Test
    public void testClassPathResource(){
        Resource classPathResouce = new ClassPathResource("spring-config.xml");

        BeanFactory beanFactory = new XmlBeanFactory(classPathResouce);
        ITestApi2  testApi1 =  beanFactory.getBean("testApi1", ITestApi2.class);
        testApi1.test();
    }





}
