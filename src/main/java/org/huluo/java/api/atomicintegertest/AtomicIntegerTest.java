package org.huluo.java.api.atomicintegertest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用AtomicInteger类在高并发的情况下进行自增数据的精准统计.
 * 与++ --自增,自减操作符在高并发的情形下统计自增数量可以参考{@link IntValueIncrementTest}
 */
public class AtomicIntegerTest {
    public static final AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        atomicIntegerTest();

        Thread.sleep(3000);
        System.out.println("最终结果是" + atomicInteger.get());
    }

    private  static void atomicIntegerTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 4; j++) {
                    System.out.println(atomicInteger.getAndIncrement());
                }
            });
        }
        executorService.shutdown();
    }
}
