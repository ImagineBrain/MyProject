package com.xzx.multithread.thread;

/**
 * @Project Name: MyProject
 * @Description:
 * @User: xiezi
 * @Date: 2018/2/2, 002
 * @Time: 22:10
 */
public class RunnableT implements Runnable {
    int i = 100;

    @Override
    public void run() {
        try {
            method1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method1() throws InterruptedException {
        i = 1000;
        Thread.sleep(250);
        System.out.println("method1 i = " + i);
    }

    public synchronized void method2() throws InterruptedException {
        i = 2000;
        Thread.sleep(500);
        System.out.println("method2 i = " + i);
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableT tt = new RunnableT();
        Thread t = new Thread(tt);
        t.start();
        tt.method2();
        System.out.println("main i = " + tt.i);
    }
}
