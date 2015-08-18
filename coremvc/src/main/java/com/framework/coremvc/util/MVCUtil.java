/**
 * Project Name:maven-quickstart
 * File Name:MVCUtil.java
 * Package Name:com.framework.coremvc.util
 * Date:2015年7月29日下午9:16:03
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */
/**
 * Project Name:maven-quickstart
 * File Name:MVCUtil.java
 * Package Name:com.framework.coremvc.util
 * Date:2015年7月29日下午9:16:03
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */

package com.framework.coremvc.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:MVCUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年7月29日 下午9:16:03 <br/>
 * @author kongming
 * @version
 * @since JDK 1.6
 * @see
 */
/**
 * ClassName: MVCUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年7月29日 下午9:16:03 <br/>
 *
 * @author kongming
 * @version
 * @since JDK 1.6
 */

public class MVCUtil {

    /**
     * 
     * toPageView:转发或重定向到视图. <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author kongming
     * @param request
     * @param response
     * @param view
     * @param isRequestDispatcher
     * @throws ServletException
     * @throws IOException
     * @since JDK 1.6
     */
    public static void toPageView(HttpServletRequest request,
	    HttpServletResponse response, String view,
	    boolean isRequestDispatcher) throws ServletException, IOException {
	if (isRequestDispatcher) {
	    request.getRequestDispatcher(view).forward(request, response);
	} else {
	    response.sendRedirect(view);
	}
    }

    public static ClassLoader getContextClassLoader() {
	ClassLoader classLoader = Thread.currentThread()
		.getContextClassLoader();
	return classLoader;
    }

    public static Class<?> getClassByClassLoader(ClassLoader classLoader,
	    String clazzName) {
	Class<?> clazz = null;
	try {
	    clazz = classLoader.loadClass(clazzName);
	} catch (ClassNotFoundException e) {

	    // TODO Auto-generated catch block
	    e.printStackTrace();

	}
	return clazz;
    }

    public static Object createObjectByType(String ptype, Object value) {
	Object obj = null;
	if ("java.lang.String".equals(ptype)) {
	    obj = String.valueOf(value);
	}
	return obj;
    }

}
