/**
 * Project Name:maven-quickstart
 * File Name:ViewRender.java
 * Package Name:com.framework.coremvc.view
 * Date:2015年7月31日上午12:13:01
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */
/**
 * Project Name:maven-quickstart
 * File Name:ViewRender.java
 * Package Name:com.framework.coremvc.view
 * Date:2015年7月31日上午12:13:01
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */

package com.framework.coremvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:ViewRender <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年7月31日 上午12:13:01 <br/>
 * @author kongming
 * @version
 * @since JDK 1.6
 * @see
 */
/**
 * ClassName: ViewRender <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年7月31日 上午12:13:01 <br/>
 *
 * @author kongming
 * @version
 * @since JDK 1.6
 */

public interface ViewRender {
    
    
    public void renderPage(HttpServletRequest request , HttpServletResponse response ,String view) throws Exception;
    

}
