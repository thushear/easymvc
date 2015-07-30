/**
 * Project Name:maven-quickstart
 * File Name:MVCContext.java
 * Package Name:com.framework.coremvc.context
 * Date:2015年7月29日下午9:07:57
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */
/**
 * Project Name:maven-quickstart
 * File Name:MVCContext.java
 * Package Name:com.framework.coremvc.context
 * Date:2015年7月29日下午9:07:57
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */

package com.framework.coremvc.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:MVCContext <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年7月29日 下午9:07:57 <br/>
 * @author kongming
 * @version
 * @since JDK 1.6
 * @see
 */
/**
 * ClassName: MVCContext <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年7月29日 下午9:07:57 <br/>
 *
 * @author kongming
 * @version
 * @since JDK 1.6
 */

public class MVCContext {

  
    public static ThreadLocal<HttpServletRequest>  requestThreadLocal = new ThreadLocal<HttpServletRequest>();
    
    public static ThreadLocal<HttpServletResponse>  responseThreadLocal = new ThreadLocal<HttpServletResponse>();
    
    
    public static HttpServletRequest getRequest(){
	return requestThreadLocal.get();
    }
   
    
    public static HttpServletResponse getResponse(){
	return responseThreadLocal.get();
    }
    
    
    
}
