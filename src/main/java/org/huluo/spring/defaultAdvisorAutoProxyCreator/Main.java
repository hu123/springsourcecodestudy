package org.huluo.spring.defaultAdvisorAutoProxyCreator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService= applicationContext.getBean(UserService.class);
        userService.print();
        System.out.println("==========分割线==========");
        userService.println();
        System.out.println(userService.getClass().getName());
    }
}