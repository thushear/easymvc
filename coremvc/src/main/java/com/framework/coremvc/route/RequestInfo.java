/**
 * Project Name:maven-quickstart
 * File Name:RequestInfo.java
 * Package Name:com.framework.coremvc.route
 * Date:2015年7月25日上午12:25:03
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */

package com.framework.coremvc.route;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName:RequestInfo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年7月25日 上午12:25:03 <br/>
 * 
 * @author kongming
 * @version
 * @since JDK 1.6
 * @see
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RequestInfo {
    
    public  String path() default "" ;
    
    public Class<?>  cls() default RequestRoute.class;
    

}
