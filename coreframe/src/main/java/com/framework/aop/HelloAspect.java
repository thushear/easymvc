package com.framework.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class HelloAspect {





    public void beforeAdvice() {

       System.out.println("=======before Advice==========");
    }


    public void beforeAdvice(String param){
        System.out.println("==========beforeAdvice======" + param);
    }


    public void afterFinallyAdvice() {
       System.out.println("=======afterFinallyAdvice=====");
    }

    public void afterReturning(Object ret){
        System.out.println("afterReturning==========" + ret);
    }


    public void afterThrowingAdvice(Exception exception) {
        System.out.println("==============afterThrowingAdvice========" + exception);
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(proceedingJoinPoint.getSignature().getName());
        System.out.println("=======before aroundAdvice=======");
        Object ret = proceedingJoinPoint.proceed(new Object[] { "have replaced" });
        System.out.println("=======after aroundAdvice=======");
        stopWatch.stop();
        System.out.println(proceedingJoinPoint.getSignature().getName() + "  cost time :" + stopWatch.getTotalTimeMillis());
        return ret;
    }




} 
