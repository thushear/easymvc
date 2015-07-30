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

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.log4j.Logger;

import com.framework.coremvc.context.MVCContext;
import com.framework.coremvc.core.CoreService;
import com.framework.coremvc.route.RequestRoute;
import com.framework.coremvc.util.ObjectUtil;
import com.framework.coremvc.view.DefaultViewRender;
import com.framework.coremvc.view.ViewRender;

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
 * @since JDK 1.6
 */

public class CoreServlet extends HttpServlet {

    private final static Logger logger = Logger.getLogger(CoreServlet.class);

    private ConcurrentHashMap<String, ConcurrentLinkedQueue<RequestRoute>> CACHE = new ConcurrentHashMap<String, ConcurrentLinkedQueue<RequestRoute>>();

    private CoreService coreService = new CoreService();

    private ViewRender defaultViewRender = new DefaultViewRender();

    @Override
    protected void service(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	MVCContext.requestThreadLocal.set(request);
	MVCContext.responseThreadLocal.set(response);

	logger.error(request.getServletPath());
	try {
	    String requestUri = request.getRequestURI();
	    String requetMethod = request.getMethod();
	    ConcurrentLinkedQueue<RequestRoute> routes = CACHE.get("routes");
	    ConcurrentHashMap resultMap = coreService.route(routes, requestUri,
		    requetMethod);
	    if (MapUtils.getBooleanValue(resultMap, "isRoute")) {
		RequestRoute requestRoute = (RequestRoute) MapUtils.getObject(
			resultMap, "route");
		Object result = coreService.methodInvoke(requestRoute);
		if (!ObjectUtil.isNullOrEmpty(result)) {
		    defaultViewRender.renderPage(request, response,
			    ObjectUtils.toString(result));
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();

	} finally {
	    MVCContext.requestThreadLocal.remove();
	    MVCContext.responseThreadLocal.remove();
	    
	}
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
