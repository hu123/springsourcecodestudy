package org.huluo.spring.required;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@Configuration
@ComponentScan(basePackages = "org.huluo.spring.required")
class MySpringConfiguration {
}
@Component
class RequiredAPIEntity{
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
    @Required
//    @Value(value = "helloworld")
    //上面的@Value注解是为了让其为password成员变量赋值的,不然添加了@Required注解不在xml配置文件中配置或者注解驱动里面去配置是会报错的
    public void setPassword(String password) {
        this.password = password;
    }
}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MySpringConfiguration.class})
public class RequiredAPITest {
    @Resource
    private RequiredAPIEntity requiredAPIEntity;


    @Test
    public void testName() throws Exception {
        System.out.println(requiredAPIEntity.getUsername());
        System.out.println(requiredAPIEntity.getPassword());
    }
}
