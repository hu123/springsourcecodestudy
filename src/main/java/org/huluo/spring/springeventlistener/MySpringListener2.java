package org.huluo.spring.springeventlistener;

import org.springframework.context.ApplicationListener;

public class MySpringListener2 implements ApplicationListener<MySpringEvent> {
    @Override
    public void onApplicationEvent(MySpringEvent event) {
        System.out.println(event + "我也来试下");
    }
}
