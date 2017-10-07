package org.huluo;

import org.junit.Test;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class SpringAsyncRestTemplateJavaFutureCallableApiTestCase {
    @Test
    public void testAsyncRestTemplate() throws Exception {
        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
        ListenableFuture<ResponseEntity<String>> responseEntityListenableFuture = asyncRestTemplate.getForEntity("http://localhost/hello", String.class);
        System.out.println(responseEntityListenableFuture);
        responseEntityListenableFuture.addCallback(result -> System.out.println("成功"), ex -> System.out.println("失败"));
        ResponseEntity<String> responseEntity = responseEntityListenableFuture.get();
        System.out.println(responseEntity.getBody());
    }


    @Test
    public void testAsyncRestTemplate1() throws Exception {
        AsyncListenableTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();

        ListenableFuture<String> listenableFuture = simpleAsyncTaskExecutor.submitListenable(() -> {
            System.out.println("helloworld");
            Thread.sleep(20000);
            return "返回的值";
        });

        System.out.println("呵呵呵");
        System.out.println("呵呵呵");
        System.out.println("呵呵呵");
        System.out.println("呵呵呵");
        System.out.println("呵呵呵");
        System.out.println("呵呵呵");

        listenableFuture.addCallback(result -> System.out.println("成功"), ex -> System.out.println("打印的失败" + ex));

        System.out.println(listenableFuture.get());

    }

    @Test
    public void testJavaFutureCallableApi() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> stringFuture = executorService.submit(() -> {
            System.out.println("你好,世界");
            return "helloworld";
        });

        System.out.println(stringFuture.getClass().getName());
        System.out.println(stringFuture.get());

    }



}