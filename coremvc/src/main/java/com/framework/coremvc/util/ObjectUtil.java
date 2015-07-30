/**
 * Project Name:maven-quickstart
 * File Name:ObjectUtil.java
 * Package Name:com.framework.coremvc.util
 * Date:2015年7月30日下午11:51:53
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */
/**
 * Project Name:maven-quickstart
 * File Name:ObjectUtil.java
 * Package Name:com.framework.coremvc.util
 * Date:2015年7月30日下午11:51:53
 * Copyright (c) 2015, thushear All Rights Reserved.
 *
 */

package com.framework.coremvc.util;

/**
 * ClassName:ObjectUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年7月30日 下午11:51:53 <br/>
 * @author kongming
 * @version
 * @since JDK 1.6
 * @see
 */
/**
 * ClassName: ObjectUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年7月30日 下午11:51:53 <br/>
 *
 * @author kongming
 * @version
 * @since JDK 1.6
 */

public class ObjectUtil {

    /**
     * 
     * isNullOrEmpty:判断对象是否为空或者null. <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author kongming
     * @param obj
     * @return
     * @since JDK 1.6
     */
    public static boolean isNullOrEmpty(Object obj) {
	return obj == null || "".equals(obj.toString().trim())
		|| "null".equals(obj.toString().trim());
    }

}
