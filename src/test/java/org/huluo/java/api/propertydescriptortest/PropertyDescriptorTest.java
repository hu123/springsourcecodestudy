package org.huluo.java.api.propertydescriptortest;

import org.huluo.spring.ioc.propertyInjection.bean.Student;
import org.junit.Test;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * 使用{@link PropertyDescriptor}进行Java Bean的get,set方法进行访问
 */
public class PropertyDescriptorTest {
    @Test
    public void testPropertyDescriptor() throws Exception {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("username", Student.class);
        Method writeMethod = propertyDescriptor.getWriteMethod();
        Student student = new Student();
        writeMethod.invoke(student, "老胡");
        Method readMethod = propertyDescriptor.getReadMethod();
        System.out.println(readMethod.invoke(student));
    }
}
