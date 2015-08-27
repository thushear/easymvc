package com.framework.aop;


public interface IHelloService {

   public void sayBeforeAdvisor();

   public void sayAround(String param);

   public void sayAfterFinally();

   public void sayAfterThrowing();

   public boolean sayAfterReturing();

   public void sayHelloParam(String param);

   public  void  sayHello();

} 
