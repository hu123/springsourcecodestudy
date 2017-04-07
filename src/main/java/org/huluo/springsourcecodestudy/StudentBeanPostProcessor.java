package org.huluo.springsourcecodestudy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class StudentBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("student")) {
            System.out.println("真的对象?" + ((Student)bean).getUsername());
            System.out.println("bean的名字是" + beanName);
            return bean;
        }else{
            return null;
        }

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("student")) {
            System.out.println("................");
            return bean;
        }else {
            return null;
        }

    }
}
