package com.framework.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 不推荐使用 属于侵入式设计
 */
public class BeforeAdvice implements MethodBeforeAdvice{

 @Override
 public void before(Method method, Object[] args, Object target) throws Throwable {
    System.out.println("before advice of " + method.getName());
 }
}
