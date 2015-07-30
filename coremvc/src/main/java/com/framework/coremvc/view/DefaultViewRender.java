/**
 * Project Name:maven-quickstart
 * File Name:DefaultViewRender.java
 * Package Name:com.framework.coremvc.view
 * Date:2015年7月31日上午12:14:55
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */

package com.framework.coremvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.framework.coremvc.util.MVCUtil;

/**
 * ClassName:DefaultViewRender <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年7月31日 上午12:14:55 <br/>
 * 
 * @author kongming
 * @version
 * @since JDK 1.6
 * @see
 */
public class DefaultViewRender implements ViewRender {

    /**
     *           
    		* TODO 渲染默认jsp页面
    		* @see com.framework.coremvc.view.ViewRender#renderPage(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.String)
     */
    public void renderPage(HttpServletRequest request,
	    HttpServletResponse response, String view) throws Exception {
	MVCUtil.toPageView(request, response, view, true);
	
    }

}
