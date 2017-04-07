package org.huluo.springsourcecodestudy;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class XmlBeanFactoryTest {
    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("spring/factoryBean.xml");
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);

//        xmlBeanFactory.addBeanPostProcessor((BeanPostProcessor) xmlBeanFactory.getBean("studentBeanPostProcessor"));
        Student student = (Student) xmlBeanFactory.getBean("student");
        Teacher teacher = (Teacher) xmlBeanFactory.getBean("teacher");


        System.out.println(student.getPassword());
        System.out.println("老师的名字是" + teacher.getTeacherName());
    }
}
