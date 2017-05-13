package org.huluo.spring.springeventlistener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringEventListenerMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringEventListenerConfiguration.class);

        applicationContext.publishEvent(applicationContext.getBean("mySpringEvent", MySpringEvent.class));
    }
}
