package org.huluo.spring.springeventlistener;

import org.springframework.context.ApplicationEvent;


public class MySpringEvent extends ApplicationEvent {
    public MySpringEvent(Object source) {
        super(source);
    }

}
