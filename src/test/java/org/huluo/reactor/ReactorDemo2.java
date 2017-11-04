package org.huluo.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;

class MyClass {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public class ReactorDemo2 {


    @Test
    public void testName() throws Exception {
        MyClass user1 = new MyClass();
        user1.setUsername("111");
        user1.setPassword("一一一");

        MyClass user2 = new MyClass();
        user2.setUsername("222");
        user1.setPassword("二二二");

        Flux<MyClass> myClassFlux = Flux.just(user1, user2);

        myClassFlux.subscribe(myClass -> System.out.println("我是这样消费的 -->" + myClass.getUsername() + "=" + myClass.getPassword()));

    }
}
