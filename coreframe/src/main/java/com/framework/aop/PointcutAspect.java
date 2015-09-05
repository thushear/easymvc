package com.framework.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by thushear on 2015/8/31.
 */
@Aspect
public class PointcutAspect {

    /*execution*/

    //	execution：用于匹配方法执行的连接点；

    @Before(value = "execution(public * *(..))")
    public void  executionTest1(JoinPoint joinPoint) {
        dump("  @Before(value = \"execution(public * *(..))\")" , joinPoint);
    }


    @Before(value = "execution(* com.framework..IPointcutService.*())")
    public void executionTest2 (JoinPoint joinPoint) {
        dump(" @Before(value = \"execution(* com.framework..IPointcutService.*())\")" , joinPoint);
    }


    @Before(value = "execution(* com.framework..*.*(..))" )
    public void executionTest3 ( JoinPoint joinPoint ) {
        dump(" @Before(value = \"execution(* com.framework..*.*(..))\" )" , joinPoint);
    }

    @Before(value = "execution(* com.framework..IPointcutService.*(*) )")
    public void exectionTest4(JoinPoint joinPoint ) {
        dump(" @Before(value = \"execution(* com.framework..IPointcutService.*(*) )\")" , joinPoint);
    }

    //特殊用法 ! +
    @Before(value = "execution(* (!com.framework..IPointcutService+).*(..) )")
    public void executionTest5(JoinPoint joinPoint) {
        dump(" @Before(value = \"execution(* (!com.framework..IPointcutService+).*(..) )\")" , joinPoint);
    }

    @Before(value = "execution(* com.framework..IPoint*.test*(java.util.Date) )")
    public void executionTest6(JoinPoint joinPoint ) {
        dump("@Before(value = \"execution(* com.framework..IPoint*.test*(java.util.Date) )\")" , joinPoint);
    }


    @Before(value = "execution(* com.framework..IPoint*.test*(..) throws NullPointerException )")
    public void executionTest7(JoinPoint joinPoint) {
        dump(" @Before(value = \"execution(* com.framework..IPoint*.test*(..) throws NullPointerException\")",
                joinPoint);
    }


    @Before(value = "execution(@com.framework.aop.Security * *(..))")
    public void executionTest8(JoinPoint joinPoint) {
        dump("@Before(value = \"execution(@com.framework.aop.Security * *(..))\")" , joinPoint);
    }


    /**
     * 返回值类型持有 Security
     * @param joinPoint
     */
    @Before(value = "execution((@com.framework.aop.Security *) *(..))")
    public void executionTest9 (JoinPoint joinPoint) {
        dump(" @Before(value = \"execution((@com.framework.aop.Security *) *(..))\")" , joinPoint);
    }


    // withIn 语法

    @Before(value = "within(com.framework..*)")
    public void withInTest1(JoinPoint joinPoint) {
        dump( " @Before(value = \"within(com.framework..*)\")" , joinPoint);
    }

    @Before(value =  "within(com.framework..IPointcutService+)")
    public void withInTest2(JoinPoint joinPoint) {
        dump("@Before(value =  \"within(com.framework..IPointcutService+)\")" , joinPoint);
    }


    /**
     * 持有cn.javass..Secure注解的任何类型的任何方法
     必须是在目标对象上声明这个注解，在接口上声明的对它不起作用

     * @param joinPoint
     */
    @Before(value =  "within(@com.framework.aop.Security *)")
    public void withInTest3(JoinPoint joinPoint) {
        dump("@Before(value =  \"within(@com.framework.aop.Security *)\")" , joinPoint);
    }


    // this 语法

    @Before(value = "this(com.framework.aop.IPointcutService)")
    public void thisTest(JoinPoint joinPoint) {
        dump("@Before(value = \"this(com.framework.aop.IPointcutService)\")" , joinPoint);
    }


    //target 语法

    @Before(value = "target(com.framework.aop.IPointcutService)")
    public void targetTest(JoinPoint joinPoint) {
        dump("@Before(value = \"target(com.framework.aop.IPointcutService)\")" , joinPoint);
    }


    void dump(String experssion , JoinPoint joinPoint) {
        System.out.printf("expression = %s , matches method = %s \n" , experssion , joinPoint.getSignature().toLongString());
    }

}
