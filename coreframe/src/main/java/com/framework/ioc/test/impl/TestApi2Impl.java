package com.framework.ioc.test.impl;

import com.framework.ioc.test.ITestApi2;
/**
 * Created by Administrator on 2015/8/4.
 */
public class TestApi2Impl implements ITestApi2 {

    private String message ;

    public TestApi2Impl() {
        this.message = "test1";
    }

    public TestApi2Impl(String message) {
        this.message = message;
    }

    @Override
    public void test() {
        System.out.println(message);
    }
}
