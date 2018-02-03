package com.xzx.multithread.semaphone;

import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

/**
 * Project Name: MyProject
 * User: xiezi
 * Date: 2018/1/15, 015
 * Time: 0:11
 */
public class SemaphoneTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 5; i++) {
            try {
                new Thread(new FutureTask(new SemaphoneCallable(i, semaphore))).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
