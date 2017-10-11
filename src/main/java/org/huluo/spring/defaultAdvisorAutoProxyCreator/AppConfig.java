package org.huluo.spring.defaultAdvisorAutoProxyCreator;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class AppConfig {
    @Resource
    private MyMethodInterceptor myMethodInterceptor;
    //要创建代理的目标Bean
    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
    //创建Advice
    @Bean
    public Advice myMethodInterceptor(){
        return new MyMethodInterceptor();
    }
    //使用Advice创建Advisor
    @Bean
    public NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor(){
        NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor=new NameMatchMethodPointcutAdvisor();
        nameMatchMethodPointcutAdvisor.setMappedName("pri*");
        nameMatchMethodPointcutAdvisor.setAdvice(myMethodInterceptor);
        return nameMatchMethodPointcutAdvisor;
    }
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }
}