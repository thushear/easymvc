package com.framework.ioc.di;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/8/4.
 */
public class SpringDITest extends TestCase{

    private ApplicationContext applicationContext;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @Test
    public void testByIndex(){
        DITestApi byIndex = applicationContext.getBean("byIndex", DITestApi.class);
        byIndex.test();
    }


    @Test
    public void testbyName(){
        DITestApi byName = applicationContext.getBean("byName", DITestApi.class);
        byName.test();
    }


    @Test
    public void testbyType(){
        DITestApi byType = applicationContext.getBean("byType", DITestApi.class);
        byType.test();
    }

    @Test
    public void testbySetter(){
        DITestApi bySetter = applicationContext.getBean("bySetter", DITestApi.class);
        bySetter.test();
    }


    @Test
    public void testbeanSetter(){
        DITestDecorator diTestDecorator = applicationContext.getBean("beanBySetter", DITestDecorator.class);
        diTestDecorator.test();
    }


    /**
     * AbstractAutowireCapableBeanFactory 中的代码 解决了单例模式 下 循环依赖的问题 所以都是单例的
     * 情况下可以循环依赖
     * addSingletonFactory(beanName, new ObjectFactory() {
     public Object getObject() throws BeansException {
     return getEarlyBeanReference(beanName, mbd, bean);
     }
     });

     prototype会抛出 BeanCurrentlyInCreationException 异常 创建失败
     */
    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleDependency() throws Throwable{
        try {
            applicationContext.getBean("circleA",CircleA.class);
        } catch (Exception e) {
            throw e.getCause().getCause();
        }
    }


    /**
     * 自动装配 byName
     */
    @Test
    public void  testAutoWireByName(){
        DITestDecorator dITestDecorator = applicationContext.getBean("DITestDecorator", DITestDecorator.class);
        dITestDecorator.test();
    }


    /**
     * 自动装配 byType
     */
    @Test
    public void  testAutoWirebyType(){
        DITestDecorator dITestDecorator = applicationContext.getBean("DITestDecorator1", DITestDecorator.class);
        dITestDecorator.test();
    }

}
