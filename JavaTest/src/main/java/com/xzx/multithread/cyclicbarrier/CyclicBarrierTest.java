package com.xzx.multithread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Project Name: MyProject
 * User: xiezi
 * Date: 2018/1/14, 014
 * Time: 19:44
 */
public class CyclicBarrierTest {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
        public void run() {
            System.out.println("Run Now");
        }
    });

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(new CyclicBarrierThread(i, cyclicBarrier));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
