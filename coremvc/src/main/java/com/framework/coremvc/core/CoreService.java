/**
 * Project Name:maven-quickstart
 * File Name:CoreService.java
 * Package Name:com.framework.coremvc.core
 * Date:2015年7月25日上午12:33:27
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */

package com.framework.coremvc.core;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.framework.coremvc.route.RequestInfo;
import com.framework.coremvc.route.RequestMethod;
import com.framework.coremvc.route.RequestRoute;
import com.framework.coremvc.util.ScanClassPathUtil;

/**
 * ClassName:CoreService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年7月25日 上午12:33:27 <br/>
 * 
 * @author kongming
 * @version
 * @since JDK 1.6
 * @see
 */
public class CoreService {
    
    
    
    
    
    
    

     
    
    /**
     *         
     *           
    		* route:路由算法. <br/>
    		* TODO(这里描述这个方法适用条件 – 可选).<br/>
    		* TODO(这里描述这个方法的执行流程 – 可选).<br/>
    		* TODO(这里描述这个方法的使用方法 – 可选).<br/>
    		* TODO(这里描述这个方法的注意事项 – 可选).<br/>
    		*
    		* @author kongming
    		* @param routes
    		* @param requestUrl
    		* @param requestMethod
    		* @return
    		* @since JDK 1.6
     */
    public ConcurrentHashMap<String, Object>  route(ConcurrentLinkedQueue<RequestRoute> routes , String requestUrl , String requestMethod){
 	ConcurrentHashMap<String, Object> result = new ConcurrentHashMap<String, Object>();
    	for(RequestRoute requestRoute : routes){
	    
	    if(!requestRoute.getPath().contains("{")&&!requestRoute.getPath().contains("}")){
		if(requestRoute.getPath().equalsIgnoreCase(requestUrl) && requestRoute.getHttpMethod().equals(requestMethod)){
			result.put("isRoute", true);
 			result.put("route", requestRoute);
			return result;
		    }
	    }else {
		String routeUrls[] =  requestRoute.getPath().split("/");
 		String inUrls[] = requestUrl.split("/");
		if(requestRoute.getPath().contains("{")&&requestRoute.getPath().contains("}")&&requestRoute.getLength() == inUrls.length&&requestRoute.getHttpMethod().equalsIgnoreCase(requestMethod)){
			Map<String, Object> params = new HashMap<String, Object>();
			List res  = new ArrayList();
			
			for(int i = 0;i< routeUrls.length;i++){
			    if(!inUrls[i].equals(routeUrls[i])){
				if(  routeUrls[i].contains(".")&&routeUrls[i].contains("{")&&routeUrls[i].contains("}")){
					params.put(routeUrls[i].substring(routeUrls[i].indexOf("{") + 1, routeUrls[i].indexOf("}") ), inUrls[i].substring(0,inUrls[i].indexOf(".")));
				    }else if(routeUrls[i].contains("{")&&routeUrls[i].contains("}")){
					params.put(routeUrls[i].substring(routeUrls[i].indexOf("{") + 1, routeUrls[i].indexOf("}")), inUrls[i]);
				    }
			    }
			    else{
				res.add(inUrls[i]);
			    }
			}
			if(params.keySet().size() + res.size() == requestRoute.getLength()){
			        requestRoute.setParams(params);
			    	result.put("isRoute", true);
				result.put("route", requestRoute);
				return result;
			}

		}
		// {test}.html
		
	    }
	    
	}
    	result.put("isRoute", false);
	result.put("route", new RequestRoute());
	return result;
    }
    
    
     
    public ConcurrentLinkedQueue<RequestRoute>  getRouteInfos(String packageDir){
	ConcurrentLinkedQueue<RequestRoute>  routes = new ConcurrentLinkedQueue<RequestRoute>();
	ScanClassPathUtil handler = new ScanClassPathUtil(null);
	Set<Class<?>> clazzes =  handler.getClassesUnderPkg(packageDir, true);
	for(Class c : clazzes){
	    List<Method> methodList = new ArrayList<Method>();
	    System.out.println("methodList : " + Arrays.toString(c.getMethods()));
	    for(Method m : c.getMethods()){
		if(!Modifier.isStatic(m.getModifiers())){
		    methodList.add(m);
		}
	    }
	    for(Method m : methodList){
		if(m.isAnnotationPresent(RequestInfo.class)){
		    RequestRoute requestRoute = new RequestRoute();
		    RequestInfo requestInfo = m.getAnnotation(RequestInfo.class);
		    requestRoute.setMethods(c.getMethods());
		    requestRoute.setClazz(c.getName());
		    requestRoute.setMethod(m.getName());
		    if(c.isAnnotationPresent(RequestInfo.class)){
			RequestInfo requestInfo2 = (RequestInfo) c.getAnnotation(RequestInfo.class);
			//RequestInfo requestInfo2 = (RequestInfo) c.getDeclaredAnnotation(RequestInfo.class);
			String path  = requestInfo2.path() + requestInfo.path();
			requestRoute.setPath(path);
			requestRoute.setLength(path.split("/").length);
		    }
		    
		    if(m.isAnnotationPresent(RequestMethod.class)){
			RequestMethod requestMethod =  m.getAnnotation(RequestMethod.class);
			requestRoute.setHttpMethod(requestMethod.requestMethod().toString());
			requestRoute.setHttpReturnType(requestMethod.returnType().toString());
		    }
		    
		    
		    routes.add(requestRoute);
		    
		}
	    }
	    
	}
	
	
	return routes;
    }
   
    
    
    public static void main(String[] args) {
	CoreService coreService  = new CoreService();
        ConcurrentLinkedQueue<RequestRoute> result  = coreService.getRouteInfos("com.framework.coremvc.web");
        System.out.println(result);
        ConcurrentHashMap   map =  coreService.route(result, "/demo/demo1", "GET");
        System.out.println(map);
        map = coreService.route(result, "/demo/demo2/demo2", "POST");
        System.out.println(map);
    }
    
    
}
