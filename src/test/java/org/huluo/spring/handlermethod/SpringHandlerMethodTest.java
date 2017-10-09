package org.huluo.spring.handlermethod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.method.HandlerMethod;

import javax.annotation.Resource;
import java.lang.reflect.Method;


@Component
class MyObject implements BeanFactoryAware {

    private BeanFactory factory;

    @Deprecated
    public void sayHello() {
        System.out.println("打印下,你好世界");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        factory = beanFactory;
    }

    public BeanFactory getFactory() {
        return factory;
    }
}

@Configuration
@ComponentScan(basePackages = {"org.huluo.spring.handlermethod"})
class Springctx {

}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Springctx.class})
public class SpringHandlerMethodTest {

    @Resource
    private MyObject myObject;

    @Test
    public void testName() throws Exception {
        HandlerMethod handlerMethod = new HandlerMethod(new MyObject(), "sayHello");
        System.out.println(handlerMethod);
        Method method = handlerMethod.getMethod();
        method.invoke(new MyObject());
        System.out.println(handlerMethod.getMethodAnnotation(Deprecated.class));
    }

    @Test
    public void testName1() throws Exception {
        BeanFactory beanFactory = myObject.getFactory();
        Class<?> myObjectClazz = MyObject.class;
        Method method = myObjectClazz.getDeclaredMethod("sayHello");
        HandlerMethod handlerMethod = new HandlerMethod("myObject", beanFactory, method);
        System.out.println(handlerMethod);
        System.out.println(beanFactory.getClass().getName());

    }
}
