/**
 * Project Name:maven-quickstart
 * File Name:RequestRoute.java
 * Package Name:com.framework.coremvc.route
 * Date:2015年7月25日上午12:30:02
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */

package com.framework.coremvc.route;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * ClassName:RequestRoute <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年7月25日 上午12:30:02 <br/>
 * 
 * @author kongming
 * @version
 * @since JDK 1.6
 * @see
 */
public class RequestRoute {
    
    private Map<String, Object> params ;
    
    private String httpReturnType;
    
    private String httpMethod;
    
    private String method;
    
    private String path;
    
    private int length;
    
    private String  clazz;
    
    private Method[] methods;

    
    
    
    
    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

       public Method[] getMethods() {
        return methods;
    }

    public void setMethods(Method[] methods) {
        this.methods = methods;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getHttpReturnType() {
        return httpReturnType;
    }

    public void setHttpReturnType(String httpReturnType) {
        this.httpReturnType = httpReturnType;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }
    
    
    
    
    
    
    
    
    

}
