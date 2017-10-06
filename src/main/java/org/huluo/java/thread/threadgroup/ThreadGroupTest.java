package org.huluo.java.thread.threadgroup;

import java.util.Arrays;
import java.util.stream.Stream;

public class ThreadGroupTest {

    public static void main(String[] args) {
        processThreadExceptionUseThreadGroup();
    }

    /**
     * 未捕获异常处理
     * ThreadGroup中有一个uncaughtException()方法。
     * 当线程组中某个线程发生Unchecked exception异常时，由执行环境调用此方法进行相关处理，如果有必要，可以重新定义此方法
     */
    public static void processThreadExceptionUseThreadGroup() {

        ThreadGroup threadGroup = new ThreadGroup("我的线程组"){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("在线程组里统一处理了" + t.getName() + "线程的" + e.getClass().getName() + "异常");
            }
        };
        Thread thread = new Thread(threadGroup, () -> {
            System.out.println("先执行一行代码");
            throw new RuntimeException("故意抛出运行时异常");
        }, "我的线程");

        thread.start();
    }

    /**
     * 这样可以复制group里面的thread信息
     */
    public static void copyThreadInThreadGroup() {
        ThreadGroup threadGroup1 = new ThreadGroup("线程组1");
        Thread thread1 =new Thread(threadGroup1, () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"group1's member");
        thread1.start();
        //这样可以复制group里面的thread信息
        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        Arrays.asList(threads).stream().forEach(thread -> System.out.println(thread));
        System.out.println("========================");
        Thread[] ts = new Thread[threadGroup1.activeCount()];
        threadGroup1.enumerate(ts);
        Stream.of(ts).forEach(thread -> System.out.println(thread.getName()));
        System.out.println(threadGroup1.activeCount());
    }

    public static void threadGroupName() {
        //======获取当前线程所属线程组的名字
        System.out.println(Thread.currentThread().getThreadGroup().getName());
    }
}


class ThreadGroupCtxTestClazz implements Runnable{
    @Override
    public void run() {

    }
}
