package com.framework.ioc.autowire;

import javax.annotation.Resource;

public class TestBeanInjectByResource {

  @Resource
  private String message;

 @Resource(name = "long2")
  private Long l;

 public Long getL() {
  return l;
 }

 public void setL(Long l) {
  this.l = l;
 }

 public String getMessage() {
  return message;
 }

 public void setMessage(String message) {
  this.message = message;
 }
}
