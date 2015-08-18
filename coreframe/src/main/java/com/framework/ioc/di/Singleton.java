package com.framework.ioc.di;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by Administrator on 2015/8/5.
 */
public class Singleton {

    // 私有构造器
    private Singleton() {
    }

    private static class InstanceHolder{
        //惰性初始化
        private static final Singleton INSTANCE  = new Singleton();
    }

    //统一入口
    public static Singleton getInstance(){
        return InstanceHolder.INSTANCE;
    }

    private int classLoaderCount = 0;

    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this);
    }
}
