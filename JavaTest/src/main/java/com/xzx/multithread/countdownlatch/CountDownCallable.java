package com.xzx.multithread.countdownlatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Project Name: MyProject
 * User: xiezi
 * Date: 2018/1/14, 014
 * Time: 19:35
 */
public class CountDownCallable implements Callable {
    CountDownLatch countDownLatch;
    int i;

    public CountDownCallable(CountDownLatch countDownLatch, int i) {
        this.countDownLatch = countDownLatch;
        this.i = i;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("Callable" + i);
        countDownLatch.countDown();
        return "Callable" + i;
    }
}
