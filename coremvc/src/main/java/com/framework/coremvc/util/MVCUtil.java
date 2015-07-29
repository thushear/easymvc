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
    
    
    public static Object createObjectByType(String ptype,Object value){
	 Object  obj = null;
	 if("java.lang.String".equals(ptype)){
	     obj = String.valueOf(value);
	 }
	 return obj;
    }
    
    

}
