package com.framework.ioc.di;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2015/8/6.
 */
public class BeanDefinitionRegister {

    private static final Map<String,BeanDefinition>  BEANNAMESDEFINITIONS = new ConcurrentHashMap<String, BeanDefinition>();


    public void  registerBeanDefiniton( BeanDefinition beanDefinition){
        String id = beanDefinition.getId();
        if (BEANNAMESDEFINITIONS.containsKey(id)){
            throw new RuntimeException();
        }
        BEANNAMESDEFINITIONS.put(id,beanDefinition);
    }

    public BeanDefinition getBeanDefiniton(String beanName){
        return BEANNAMESDEFINITIONS.get(beanName);

    }

    public boolean containsBean(String beanName){
        return BEANNAMESDEFINITIONS.containsKey(beanName);
    }



}
