/**
 * Project Name:maven-quickstart
 * File Name:DemoController.java
 * Package Name:com.framework.coremvc.web
 * Date:2015年7月26日下午12:27:52
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */
/**
 * Project Name:maven-quickstart
 * File Name:DemoController.java
 * Package Name:com.framework.coremvc.web
 * Date:2015年7月26日下午12:27:52
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */

package com.framework.coremvc.web;

import com.framework.coremvc.controller.annotation.QueryParam;
import com.framework.coremvc.route.RequestInfo;
import com.framework.coremvc.route.RequestMethod;
import com.framework.coremvc.route.RequestMethod.HttpMethod;
import com.framework.coremvc.route.RequestMethod.HttpReturnType;

/**
 * ClassName:DemoController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年7月26日 下午12:27:52 <br/>
 * @author kongming
 * @version
 * @since JDK 1.6
 * @see
 */

/**
 * ClassName: DemoController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年7月26日 下午12:27:52 <br/>
 *
 * @author kongming
 * @since JDK 1.6
 */
@RequestInfo(path = "/demo")
public class DemoController {

	@RequestInfo(path = "/demo1.htm")
	@RequestMethod(requestMethod = HttpMethod.GET, returnType = HttpReturnType.STRING)
	public String demo1(@QueryParam("id") String id, @QueryParam("name") String name) {
		System.out.println("id = " + id + ", name =" + name);
		return null;
	}

	@RequestInfo(path = "/demo2/{demo2}")
	@RequestMethod(requestMethod = HttpMethod.POST, returnType = HttpReturnType.STRING)
	public String demo2() {
		return null;
	}

}
