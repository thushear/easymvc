package com.framework.ioc.di;

/**
 * Created by Administrator on 2015/8/4.
 */
public class DITestImpl implements DITestApi{

    private String message ;


    public DITestImpl() {
    }

    public DITestImpl(String message) {
        this.message = message;
    }

    @Override
    public void test() {
        System.out.println(message);
    }


    public void setMessage(String message) {
        this.message = message;
    }
}
