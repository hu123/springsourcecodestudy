package org.huluo.java.api.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorServiceInvokeAnyCallableInterface(executorService);
    }


    public void chore(ExecutorService executorService) throws InterruptedException {
        executorService.execute(() -> {
            while (true) {

            }
        });
        executorService.execute(() -> System.out.println("未执行的任务我是"));

        System.out.println(executorService.isShutdown());

        List<Runnable> runnableList = executorService.shutdownNow();

        System.out.println(runnableList);

        System.out.println(executorService.isTerminated());
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("awaitTermination方法阻塞解除后才执行");
    }


    public static void executorServiceInvokeAllCallableInterface(ExecutorService executorService) throws InterruptedException {
        List<Callable<String>> callableList = new ArrayList<>();
        callableList.add(() -> "aaa");
        callableList.add(() -> "bbb");
        callableList.add(() -> {
            Thread.sleep(500);
            return "ccc";
        });
        if (null != executorService) {
            List<Future<String>> futures = executorService.invokeAll(callableList,1,TimeUnit.SECONDS);
            futures.stream().forEach(stringFuture -> {
                try {
                    System.out.println(stringFuture.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
            executorService.shutdown();
        }
    }


    public static void executorServiceInvokeAnyCallableInterface(ExecutorService executorService) throws ExecutionException, InterruptedException, TimeoutException {

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(() -> {
            Thread.sleep(1000);
            return "ccc";
        });
        callables.add(() -> {
            Thread.sleep(3000);
            throw new RuntimeException("test");
        });
        callables.add(() -> {
            Thread.sleep(2000);
            return "bbb";
        });

        if (null != executorService) {
            String taskExecutionResult = executorService.invokeAny(callables,1,TimeUnit.SECONDS);
            System.out.println(taskExecutionResult);
            executorService.shutdownNow();
        }
    }
}
