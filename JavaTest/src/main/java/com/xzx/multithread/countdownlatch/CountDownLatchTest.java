package com.xzx.multithread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Project Name: MyProject
 * User: xiezi
 * Date: 2018/1/14, 014
 * Time: 18:58
 */
public class CountDownLatchTest {
    static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Future future = es.submit(new CountDownCallable(countDownLatch, i));
        }
        try {
            countDownLatch.await(); // 等待子线程完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main");
        es.shutdown();
    }
}
