package com.framework.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by thushear on 2015/8/31.
 */

@Target(value = {ElementType.METHOD , ElementType.TYPE , ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Security {


}
