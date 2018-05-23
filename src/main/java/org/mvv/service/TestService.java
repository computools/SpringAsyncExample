package org.mvv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Service
public class TestService {

    private final Test1 test1;
    private final Test2 test2;
    private final Test3 test3;

    @Autowired
    public TestService(Test1 test1, Test2 test2, Test3 test3) {
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
    }

    @Async
    @Scheduled(fixedDelay = 200000)
    public void test() throws ExecutionException, InterruptedException, TimeoutException {
        long start = System.currentTimeMillis();
        CompletableFuture<String > result1 = test1.test();
        CompletableFuture<String > result2 = test1.test();
        CompletableFuture<String > result3 = test1.test();


        System.out.println(result1.get());
        System.out.println(result2.get());
        System.out.println(result3.get());

        long finish = System.currentTimeMillis();

        System.out.println(Thread.currentThread().getName() + " <- Tread name. Time processed -> " + (finish - start));
    }
}
