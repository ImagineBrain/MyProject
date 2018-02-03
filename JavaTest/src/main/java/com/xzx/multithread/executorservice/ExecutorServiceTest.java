package com.xzx.multithread.executorservice;

import java.util.concurrent.*;

/**
 * Project Name: MyProject
 * User: xiezi
 * Date: 2018/1/14, 014
 * Time: 16:47
 */
public class ExecutorServiceTest {

    public void singleTest() {
        ExecutorService es = Executors.newSingleThreadExecutor(); // 单线程线程池
        for (int i = 0; i < 5; i++) {
            Callable callable = new MyCallable(i);
            Future<Integer> future = es.submit(callable); // 线程依次执行
        }
        es.shutdown();
    }

    public void fixThreadPoolTest() {
        ExecutorService es = Executors.newFixedThreadPool(5); // 定长线程线程池，超过长度则等待
        for (int i = 0; i < 5; i++) {
            Callable callable = new MyCallable(i);
            Future<Integer> future = es.submit(callable);
        }
        es.shutdown();
    }

    public void cachedThreadPoolTest() {
        ExecutorService es = Executors.newCachedThreadPool(); // 缓存线程线程池,无限大
        for (int i = 0; i < 5; i++) {
            Callable callable = new MyCallable(i);
            Future<Integer> future = es.submit(callable);
        }
        es.shutdown();
    }

    public void scheduleThreadPoolTest() {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(5); // 定长计划线程线程池，定时执行任务，超过长度则等待
        for (int i = 0; i < 5; i++) {
            Callable callable = new MyCallable(i);
            es.schedule(callable, 1, TimeUnit.SECONDS);
        }
        es.shutdown();
    }

    public static void main(String[] args) {
        ExecutorServiceTest est = new ExecutorServiceTest();
//        est.singleTest();
//        est.fixThreadPoolTest();
//        est.cachedThreadPoolTest();
        est.scheduleThreadPoolTest();
    }
}
