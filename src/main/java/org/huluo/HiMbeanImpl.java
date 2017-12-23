package org.huluo;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;



/**
 *简单实现类
 * @author Lenovo
 * @version $Id: Hi.java, v 0.1 2014年9月26日 下午2:48:09 Lenovo Exp $
 */
public class HiMbeanImpl implements HiMBean {

    private final String     name               = "Reginald";
    private int              cacheSize          = DEFAULT_CACHE_SIZE;
    private static final int DEFAULT_CACHE_SIZE = 200;

    /**
     * @see com.cathy.demo.jmx.notifications.HiMBean#sayHello()
     */
    public void sayHello() {
        System.out.println("Hello," + getName());
    }

    /**
     * @see com.cathy.demo.jmx.notifications.HiMBean#add(int, int)
     */
    public int add(int x, int y) {
        return x + y;
    }

    /**
     * @see com.cathy.demo.jmx.notifications.HiMBean#getName()
     */
    public String getName() {
        return name;
    }

    /**
     * @see com.cathy.demo.jmx.notifications.HiMBean#getCacheSize()
     */
    public int getCacheSize() {
        return cacheSize;
    }

    /**
     * @see com.cathy.demo.jmx.notifications.HiMBean#setCacheSize(int)
     */
    public void setCacheSize(int size) {
        cacheSize = size;
    }

}