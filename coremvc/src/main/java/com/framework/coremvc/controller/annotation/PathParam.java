/**
 * Project Name:maven-quickstart
 * File Name:PathParam.java
 * Package Name:com.framework.coremvc.controller.annotation
 * Date:2015年7月29日下午9:45:36
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */
/**
 * Project Name:maven-quickstart
 * File Name:PathParam.java
 * Package Name:com.framework.coremvc.controller.annotation
 * Date:2015年7月29日下午9:45:36
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */

package com.framework.coremvc.controller.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName:PathParam <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年7月29日 下午9:45:36 <br/>
 * @author kongming
 * @version
 * @since JDK 1.6
 * @see
 */
/**
 * ClassName: PathParam <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年7月29日 下午9:45:36 <br/>
 *
 * @author kongming
 * @version
 * @since JDK 1.6
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PathParam {
    
    
    public String value() default "";

}
