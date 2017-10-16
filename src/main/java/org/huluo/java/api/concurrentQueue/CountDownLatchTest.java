package org.huluo.java.api.concurrentQueue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    private static final CountDownLatch countDownLatch = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("3秒等待完成");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("5秒等待完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        countDownLatch.await(10, TimeUnit.SECONDS);

        System.out.println("终于得到执行了....");

    }
}
