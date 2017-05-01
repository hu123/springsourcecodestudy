package spring4.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by weixin:javajidi_com.
 * 方法执行前的逻辑，称前置通知
 */
public class BeforeAdvice implements MethodBeforeAdvice{
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("BeforeAdvice方法执行前");
        System.out.println(method.getName()+";"+o.getClass());
    }
}