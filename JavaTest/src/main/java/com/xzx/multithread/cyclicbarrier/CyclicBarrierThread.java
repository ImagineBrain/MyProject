package com.xzx.multithread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Project Name: MyProject
 * User: xiezi
 * Date: 2018/1/14, 014
 * Time: 19:50
 */
public class CyclicBarrierThread extends Thread {
    int i;
    CyclicBarrier cyclicBarrier;

    public CyclicBarrierThread(int i, CyclicBarrier cyclicBarrier) {
        this.i = i;
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        System.out.println("Thread" + i + " is ready");
        try {
            cyclicBarrier.await();
            System.out.println("Thread" + i + " is running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
