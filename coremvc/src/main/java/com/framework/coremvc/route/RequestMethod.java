/**
 * Project Name:maven-quickstart
 * File Name:RequestMethod.java
 * Package Name:com.framework.coremvc.route
 * Date:2015年7月26日下午12:48:53
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */
/**
 * Project Name:maven-quickstart
 * File Name:RequestMethod.java
 * Package Name:com.framework.coremvc.route
 * Date:2015年7月26日下午12:48:53
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
 * ClassName:RequestMethod <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年7月26日 下午12:48:53 <br/>
 * @author kongming
 * @version
 * @since JDK 1.6
 * @see
 */
/**
 * ClassName: RequestMethod <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年7月26日 下午12:48:53 <br/>
 *
 * @author kongming
 * @version
 * @since JDK 1.6
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RequestMethod {
    
    public enum HttpMethod{
	GET,POST,DELETE,PUT,TRACE,HEAD;
    }
   
    public enum HttpReturnType{
	STRING,JSON,JSONP;
    }
    
    public HttpMethod requestMethod() default HttpMethod.GET;
   
    public HttpReturnType returnType() default HttpReturnType.STRING;
    

}
