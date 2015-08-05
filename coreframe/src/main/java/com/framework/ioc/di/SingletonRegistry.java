package com.framework.ioc.di;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2015/8/5.
 */
public class SingletonRegistry implements SingletonBeanRegistry {


    private static final Map<String,Object> SINGLETONBEAS = new ConcurrentHashMap<String, Object>();

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        if (SINGLETONBEAS.containsKey(beanName)){
            throw new RuntimeException("already exists");
        }
        SINGLETONBEAS.put(beanName,singletonObject);
    }

    @Override
    public Object getSingleton(String beanName) {
        return SINGLETONBEAS.get(beanName);
    }

    @Override
    public boolean containsSingleton(String beanName) {
        return SINGLETONBEAS.containsKey(beanName);
    }

    @Override
    public String[] getSingletonNames() {
        return SINGLETONBEAS.keySet().toArray(new String[0]);
    }

    @Override
    public int getSingletonCount() {
        return SINGLETONBEAS.size();
    }
}
