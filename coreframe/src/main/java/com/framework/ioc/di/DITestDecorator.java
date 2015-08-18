package com.framework.ioc.di;

/**
 * Created by Administrator on 2015/8/4.
 */
public class DITestDecorator {

    private DITestApi diTestApi;


    public void test(){
        System.out.println("==========start=========");
        diTestApi.test();
        System.out.println("===============end========");
    }


    public void setDiTestApi(DITestApi diTestApi) {
        this.diTestApi = diTestApi;
    }
}
