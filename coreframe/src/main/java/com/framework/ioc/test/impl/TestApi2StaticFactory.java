package com.framework.ioc.test.impl;

import com.framework.ioc.test.ITestApi2;

/**
 * Created by Administrator on 2015/8/4.
 */
public class TestApi2StaticFactory {


    /**
     * 静态工厂
     * @param message
     * @return
     */
    public static ITestApi2 newInstance(String message){
        return new TestApi2Impl(message);
    }
}
