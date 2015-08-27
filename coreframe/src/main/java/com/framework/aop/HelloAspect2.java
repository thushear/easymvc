package com.framework.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StopWatch;

/**
 * Aspect 风格的 切面
 */
@Aspect
public class HelloAspect2 {

	@Pointcut(value = "execution(* com.framework..*.sayHelloParam(..)) && args(param)", argNames = "param")
	public void beforePointcut(String param) {
	}

	@Before(value = "beforePointcut(param)", argNames = "param")
	public void beforeAdvice(String param) {
		System.out.println("======before Advice ====" + param);
	}

	@AfterReturning(pointcut = "execution(* com.framework..*.sayAfterReturing(..))", argNames = "ret", returning = "ret")
	public void afterReturningAdvice(Object ret) {
		System.out.println("======afterReturningAdvice=== " + ret);
	}

	@AfterThrowing(pointcut = "execution(* com.framework..*.sayAfterThrowing(..))", throwing = "exception", argNames = "exception")
	public void afterThrowingAdvice(Exception exception) {
		System.out.println(" = ====afterThrowingAdvice==" + exception);

	}

	@Around(value = "execution(* com.framework..*.sayAround(..))")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start(proceedingJoinPoint.getSignature().getName());
		System.out.println("=======before aroundAdvice=======");
		Object ret = proceedingJoinPoint.proceed(new Object[] { "have replaced" });

		System.out.println("=======after aroundAdvice=======");
		stopWatch.stop();
		System.out.println(
				proceedingJoinPoint.getSignature().getName() + "  cost time :" + stopWatch.getTotalTimeMillis());
		return ret;

	}

} 
