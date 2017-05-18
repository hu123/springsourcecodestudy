package org.huluo.java.api.volatiletest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Value{
    public volatile static int i = 0;
//    public  static int i = 0;
}

/**
 * 该类用于演示volatile关键字的用处。
 * 分别将Value.i这个成员变量用volatile修饰
 * 不修饰的时候,程序会出现死循环。
 * 修饰的时候,程序会正常退出
 */
public class VolatileTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() ->{
            System.out.println("开始执行");
            //子线程查看Value.i的值是否为0,为0则死循环
            while (Value.i == 0) {
            }
            System.out.println("执行结束");
        });
        Thread.sleep(1000);
        //主线程将Value.i的值修改为1000
        Value.i = 1000;
        executorService.shutdown();
    }
}
