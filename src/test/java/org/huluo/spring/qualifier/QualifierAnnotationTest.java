package org.huluo.spring.qualifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ComponentScan(basePackages = "org.huluo.spring.qualifier")
@Configuration
class MySpringCtx {

}

@Service
class MyService{
    @Qualifier("one")
    @Autowired
    private UserService userService;

    public void service() {
        userService.sayHello();
    }
}

interface UserService{
    void sayHello();
}
@Component(value = "one")
class UserServiceImpl1 implements UserService{
    @Override
    public void sayHello() {
        System.out.println("UserServiceImpl1");
    }
}

@Component(value = "two")
class UserServiceImpl2 implements UserService{
    @Override
    public void sayHello() {
        System.out.println("UserServiceImpl2");
    }
}


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MySpringCtx.class})
public class QualifierAnnotationTest {
    @Autowired
    private MyService myService;
    @Test
    public void testName() throws Exception {
        myService.service();
    }
}
