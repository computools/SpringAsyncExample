package org.mvv.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class Test3 {
    @Async
    public CompletableFuture<String> test(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Processing");
        return CompletableFuture.completedFuture("test3");
    }
}
