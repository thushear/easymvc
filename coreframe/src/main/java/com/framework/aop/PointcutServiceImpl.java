package com.framework.aop;

import java.util.Date;

/**
 * Created by Administrator on 2015/8/31.
 */

@Security
public class PointcutServiceImpl implements IPointcutService {


    @Override
    public Model testModel(Model model) {
        return new Model();
    }

    @Deprecated
    @Security
    @Override
    public void test1()throws NullPointerException{
        System.out.println("test1() ");
    }

    @Override
    public void test(Date date) {
        System.out.println("test date = " + date);
    }

    @Override
    public void testOneParam(String param) {
        System.out.println("param = " + param);
    }

    @Override
    public void testDate(Date date) {
        System.out.println("date = " + date);
    }
}
