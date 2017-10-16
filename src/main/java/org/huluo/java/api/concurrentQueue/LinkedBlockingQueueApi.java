package org.huluo.java.api.concurrentQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueApi {
    public static final BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(2);

    public static void main(String[] args) throws InterruptedException {
//        proveBlockingQueuePutMethodWillBeBlockWhenCapacityIsFull();
        proveBlockingQueueTakeMethodWillBeBlockWhenCapacityIsNull();
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

    /**
     * 证明当调用阻塞队列的take()方法的时候,如果阻塞队列里面没有元素存在,则线程发生阻塞
     */
    public static void proveBlockingQueueTakeMethodWillBeBlockWhenCapacityIsNull() {
        //调用阻塞队列的take()方法取值,若没有值则发生阻塞
        new Thread(() -> {
            try {
                System.out.println("从阻塞队列拿到的值是多少呢=>" + blockingQueue.take());
                System.out.println("拿到值了,阻塞取消");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //往阻塞队列里put值,来解除调用take()方法线程的阻塞
        new Thread(() -> {
            try {
                //为了体现调用take()方法的阻塞效果,先让线程睡眠10秒钟
                Thread.sleep(10000);
                blockingQueue.put("value");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
