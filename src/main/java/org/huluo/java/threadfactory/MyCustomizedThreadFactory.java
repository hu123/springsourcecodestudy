package org.huluo.java.threadfactory;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * 自定义的线程工厂实现类
 */
public class MyCustomizedThreadFactory implements ThreadFactory {

    private int counter;

    private String name;

    private List<String> stats;
    public MyCustomizedThreadFactory(String name) {
        counter = 1;
        this.name = name;
        stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "_Thread_" + counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on %s \n", t.getId(), t.getName(), new Date().toLocaleString()));
        return t;
    }

    public String getStats() {
        if (!CollectionUtils.isEmpty(stats)) {
            StringBuffer stringBuffer = new StringBuffer();
            stats.stream().forEach(s -> stringBuffer.append(s));
            return stringBuffer.toString();
        }
        return "";
    }
}
