package com.framework.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config-aop.xml");

    @Test
    public void testAdvice(){
       IHelloService helloService =  applicationContext.getBean("helloService",IHelloService.class);
       helloService.sayHello();
    }


    @Test
    public void testBeforeAdviceAndParam(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("advice.xml");
        IHelloService helloService =  applicationContext.getBean("helloService",IHelloService.class);
        helloService.sayHelloParam("before advice");
    }


    @Test
    public void testAfterReturningAdvice(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("advice.xml");
        IHelloService helloService =  applicationContext.getBean("helloService",IHelloService.class);
        helloService.sayAfterReturing();
    }


    @Test
    public void testAfterThrowingAdvice(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("advice.xml");
        IHelloService helloService =  applicationContext.getBean("helloService",IHelloService.class);
        helloService.sayAfterThrowing();
    }


    @Test
    public void testAfterFinallyAdvice(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("advice.xml");
        IHelloService helloService =  applicationContext.getBean("helloService",IHelloService.class);
        helloService.sayAfterFinally();
    }


    @Test
    public void testAroundAdvice(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("advice.xml");
        IHelloService helloService =  applicationContext.getBean("helloService",IHelloService.class);
        helloService.sayAround("not replaced");
    }

    @Test
    public void testBeforeAdvisor(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("advice.xml");
        IHelloService helloService =  applicationContext.getBean("helloService",IHelloService.class);
        helloService.sayBeforeAdvisor();
    }



    @Test
    public void testAspectBeforeAdvice(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("advice2.xml");
        IHelloService helloService =  applicationContext.getBean("helloService",IHelloService.class);
        helloService.sayHelloParam("aspect before ");
    }


    @Test
    public void testAspectAfterReturningAdvice(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("advice2.xml");
        IHelloService helloService =  applicationContext.getBean("helloService",IHelloService.class);
        helloService.sayAfterReturing();
    }


    @Test
    public void testAspectAfterThrowingAdvice(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("advice2.xml");
        IHelloService helloService =  applicationContext.getBean("helloService",IHelloService.class);
        helloService.sayAfterThrowing();
    }


    @Test
    public void testAspectAroundAdvice(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("advice2.xml");
        IHelloService helloService =  applicationContext.getBean("helloService",IHelloService.class);
        helloService.sayAround("hello");
    }
} 
