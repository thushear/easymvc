package com.framework.aop;

public class HelloServiceImpl implements IHelloService {

 @Override
 public void sayBeforeAdvisor() {
  System.out.println("=======sayBeforeAdvisor");
 }

 @Override
 public void sayAround(String param) {
  System.out.println("====sayAround====" + param);
 }

 @Override
 public void sayAfterFinally() {
  System.out.println("========sayAfterFinally========");
  throw new RuntimeException("sayAfterFinally");
 }

 @Override
 public void sayAfterThrowing() {
  System.out.println("=========sayAfterThrowing========");
  throw new RuntimeException("sayAfterThrowing");
 }

 @Override
 public boolean sayAfterReturing() {
  System.out.println("==========sayAfterReturing====");
  return true;
 }

 @Override
 public void sayHelloParam(String param) {
  System.out.println("=======sayHelloParam======" + param);
 }

 @Override
 public void sayHello() {
  System.out.println("sayHello() invoked");
 }
}
