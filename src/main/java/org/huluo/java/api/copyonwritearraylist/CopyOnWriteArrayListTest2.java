package org.huluo.java.api.copyonwritearraylist;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyOnWriteArrayListTest2 {
    private static final ArrayList<String> arrayList = new ArrayList<>();

    static {
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
    }

    public static void addElementToArrayList(String value) {
        synchronized (arrayList) {
            System.out.println("添加的线程");
            arrayList.add(value);
            System.out.println("=========================\n");
        }
    }

    public static void readArrayListElement() {
        synchronized (arrayList) {
            System.out.println("读取的线程");
            System.out.println(arrayList);
            System.out.println("***********************\n");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //往集合中添加元素
        executorService.execute(() -> {
            for (int i = 0; i < 10; i++) {
                addElementToArrayList(String.valueOf(i));
            }

        });
        //往集合中读取元素
        executorService.execute(() -> {

            for (int i = 0; i < 10; i++) {
                readArrayListElement();
            }
        });
        executorService.shutdown();

    }
}
