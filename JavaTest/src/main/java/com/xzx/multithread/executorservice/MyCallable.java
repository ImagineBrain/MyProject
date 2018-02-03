package com.xzx.multithread.executorservice;

import java.util.concurrent.Callable;

/**
 * Project Name: MyProject
 * User: xiezi
 * Date: 2018/1/14, 014
 * Time: 18:10
 */
public class MyCallable implements Callable {
    int i;

    public MyCallable(int i) {
        this.i = i;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("" + i + "");
        return i;
    }
}
