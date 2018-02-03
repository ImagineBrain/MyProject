package com.xzx.multithread.callablefuture;

import com.xzx.multithread.executorservice.MyCallable;

import java.util.concurrent.*;

/**
 * Project Name: MyProject
 * User: xiezi
 * Date: 2018/1/14, 014
 * Time: 18:48
 */
public class CallableAndFutureTest {
    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable(0);
        FutureTask ft = new FutureTask(myCallable);
        new Thread(ft).start();
        try {
            System.out.println("Thread:" + ft.get()); // 等待返回
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future future = es.submit(myCallable);
        try {
            System.out.println("Future.get" + future.get());// 等待返回
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
