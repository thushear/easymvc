/**
 * Project Name:maven-quickstart
 * File Name:CoreServlet.java
 * Package Name:com.framework.coremvc.web
 * Date:2015年7月29日下午10:47:04
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */
/**
 * Project Name:maven-quickstart
 * File Name:CoreServlet.java
 * Package Name:com.framework.coremvc.web
 * Date:2015年7月29日下午10:47:04
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */

package com.framework.coremvc.web;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.framework.coremvc.core.CoreService;
import com.framework.coremvc.route.RequestRoute;

/**
 * ClassName:CoreServlet <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年7月29日 下午10:47:04 <br/>
 * @author kongming
 * @version
 * @since JDK 1.6
 * @see
 */
/**
 * ClassName: CoreServlet <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年7月29日 下午10:47:04 <br/>
 *
 * @author kongming
 * @version
 * @since JDK 1.6
 */

public class CoreServlet extends HttpServlet {

    private ConcurrentHashMap<String, ConcurrentLinkedQueue<RequestRoute>> CACHE = new ConcurrentHashMap<String, ConcurrentLinkedQueue<RequestRoute>>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	

    }

    @Override
    public void init() throws ServletException {
	String scanPkg = getInitParameter("scanPkg");
	CoreService coreService = new CoreService();
	ConcurrentLinkedQueue<RequestRoute> routes = coreService
		.getRouteInfos(scanPkg);
	CACHE.putIfAbsent("routes", routes);

    }

}
