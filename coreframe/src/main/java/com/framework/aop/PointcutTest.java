package com.framework.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by thushear on 2015/8/31.
 */
public class PointcutTest {


    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("pointcut.xml");



    @Test
    public void testPointcutGrammer(){
        IPointcutService pointcutService = applicationContext.getBean("pointcutService", IPointcutService.class);
        IHelloService  helloService  =  applicationContext.getBean("helloService", IHelloService.class);


        pointcutService.test1();

        pointcutService.testOneParam("one");

        helloService.sayHello();


        pointcutService.testDate(new Date());

        pointcutService.test(new Date());

        pointcutService.testModel(new Model());

    }


}
