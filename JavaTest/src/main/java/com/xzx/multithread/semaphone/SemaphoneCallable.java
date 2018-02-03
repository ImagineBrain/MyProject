package com.xzx.multithread.semaphone;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Project Name: MyProject
 * User: xiezi
 * Date: 2018/1/15, 015
 * Time: 0:06
 */
public class SemaphoneCallable implements Callable {
    int i;
    Semaphore semaphore;

    public SemaphoneCallable(int i, Semaphore semaphore) {
        this.i = i;
        this.semaphore = semaphore;
    }

    public Object call() throws Exception {
        semaphore.acquire();
        System.out.println("Thread" + i + " acquire");
        TimeUnit.SECONDS.sleep(1);
        semaphore.release();
        System.out.println("Thread" + i + " release");
        return "run";
    }
}
