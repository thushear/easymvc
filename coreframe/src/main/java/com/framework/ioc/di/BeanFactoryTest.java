package com.framework.ioc.di;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2015/8/6.
 */
public class BeanFactoryTest {


    @Test
    public void testSingleton(){
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setId(DITestImpl.class.getSimpleName());
        beanDefinition.setScope(BeanDefinition.SINGLETON_SCOPE);
        beanDefinition.setClazz(DITestImpl.class.getName());
        beanFactory.registerBeanDefiniton(beanDefinition);

        Object  obj1 = beanFactory.getBean(DITestImpl.class.getSimpleName());
        Object  obj2 = beanFactory.getBean(DITestImpl.class.getSimpleName());

        Assert.assertEquals(obj1,obj2);
    }


    @Test
    public void testPrototype(){
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setId(DITestImpl.class.getSimpleName());
        beanDefinition.setScope(BeanDefinition.PROTOTYPE_SCOPE);
        beanDefinition.setClazz(DITestImpl.class.getName());
        beanFactory.registerBeanDefiniton(beanDefinition);

        Object  obj1 = beanFactory.getBean(DITestImpl.class.getSimpleName());
        Object  obj2 = beanFactory.getBean(DITestImpl.class.getSimpleName());

        Assert.assertNotEquals(obj1,obj2);
    }

}
