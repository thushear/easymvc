package com.framework.ioc.di;

import org.junit.Test;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2015/8/5.
 */
public class SingletonTest {


    @Test
    public  void  testSingleton() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        ClassLoader classLoader = new SingletonClassLoader();
        Class clazz = classLoader.loadClass("com.framework.ioc.di.Singleton");
        Method getInstance = clazz.getDeclaredMethod("getInstance");
        Object singleton =  getInstance.invoke(clazz);
        Field field = clazz.getDeclaredField("classLoaderCount");
        field.setAccessible(true);
        Integer  classLoaderCount = field.getInt(singleton);
        field.set(singleton,classLoaderCount  + 1);
        Assert.state(field.getInt(singleton) == 1);
        System.out.println(singleton.toString());

        //===============
        ClassLoader classLoader1 = new SingletonClassLoader();
        Class clazz1 = classLoader1.loadClass("com.framework.ioc.di.Singleton");
        Method getInstance1 = clazz1.getDeclaredMethod("getInstance");
        Object singleton1 =  getInstance1.invoke(clazz);
        Field field1 = clazz1.getDeclaredField("classLoaderCount");
        field1.setAccessible(true);
        Integer  classLoaderCount1 = field1.getInt(singleton1);
        field1.set(singleton1,classLoaderCount1 + 1);

        System.out.println(singleton1.toString());

    }


}
