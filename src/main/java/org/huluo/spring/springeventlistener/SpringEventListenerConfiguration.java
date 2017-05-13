package org.huluo.spring.springeventlistener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class SpringEventListenerConfiguration {

    @Bean
    public MySpringEvent mySpringEvent() {
        String s = new String("我是应用事件对象哦");
        return new MySpringEvent(s);
    }

    @Bean
    public MySpringListener mySpringListener() {
        return new MySpringListener();
    }

    @Bean
    public MySpringListener2 mySpringListener2() {
        return new MySpringListener2();
    }
}
