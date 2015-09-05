package com.framework.aop;

import java.util.Date;

/**
 * Created by thushear on 2015/8/31.
 */
public interface IPointcutService {

    Model testModel(Model model) ;

    void test1() throws NullPointerException;

    void test(Date date) ;

    void testOneParam(String param) ;

    void testDate ( Date date ) ;
}
