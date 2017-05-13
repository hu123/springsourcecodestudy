package org.huluo.spring.springeventlistener;

import org.springframework.context.ApplicationListener;

public class MySpringListener implements ApplicationListener<MySpringEvent> {
    @Override
    public void onApplicationEvent(MySpringEvent event) {
        System.out.println(event + "---------->  拿到了Spring事件对象,并做出处理");
    }
}
