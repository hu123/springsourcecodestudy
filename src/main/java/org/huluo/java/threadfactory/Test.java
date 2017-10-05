package org.huluo.java.threadfactory;

/**
 * 测试下自定义实现的线程工厂的实现
 */
public class Test {
    public static void main(String[] args) {
        MyCustomizedThreadFactory factory = new MyCustomizedThreadFactory("这是我自定义实现的线程工厂的实现");
        Task task = new Task();
        Thread thread;
        System.out.printf("Starting the Threads\n\n");
        for (int i = 1; i <= 10; i++) {
            thread = factory.newThread(task);
            thread.start();
        }
        System.out.printf("All Threads are created now\n\n");
        System.out.printf("Give me CustomThreadFactory stats:\n\n" + factory.getStats());
    }
}
