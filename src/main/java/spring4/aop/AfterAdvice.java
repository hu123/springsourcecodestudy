package spring4.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by weixin:javajidi_com.
 */
public class AfterAdvice implements AfterReturningAdvice {

    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("AfterAdvice方法执行完成了");
        System.out.println(method.getName()+";"+o1.getClass());
    }
}