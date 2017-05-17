package org.huluo.java.api.atomicintegertest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 证明 ++ -- 自增和自减运算符是线程不安全的,在高并发的情况下自增的数量会丢失
 */
public class IntValueIncrementTest {

    public static int value = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 4; j++) {
                    System.out.println(value++);
                }
            });
        }
        executorService.shutdown();
        Thread.sleep(3000);
        System.out.println("最终结果是" + value);
    }
}
