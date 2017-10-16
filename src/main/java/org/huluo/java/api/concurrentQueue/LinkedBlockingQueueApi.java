package org.huluo.java.api.concurrentQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueApi {
    public static final BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(2);

    public static void main(String[] args) throws InterruptedException {
        proveBlockingQueuePutMethodWillBeBlockWhenCapacityIsFull();
    }

    /**
     * 证明阻塞队列在容量满的时候,在往里面put元素会发生阻塞,除非把他先消费掉
     */
    public static void proveBlockingQueuePutMethodWillBeBlockWhenCapacityIsFull() throws InterruptedException {
        //执行一个往阻塞队列中put元素的任务
        new Thread(() -> {
            try {
                blockingQueue.put("aaa");
                blockingQueue.put("bbb");
                blockingQueue.put("ccc");
                System.out.println("结束了往阻塞队列中放元素的任务");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //执行一个从阻塞队列里面消费的任务
        new Thread(() -> {
            try {
                //为了体现阻塞的效果,先让该线程睡眠10秒钟
                Thread.sleep(10000);
                System.out.println("获取到的值是" + blockingQueue.poll());
                //拿到值之后,消息队列中的元素会小于容量,阻塞取消。可以往其中继续put
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
