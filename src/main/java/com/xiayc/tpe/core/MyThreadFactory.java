package com.xiayc.tpe.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xyc on 2017/9/16 0016.
 */
public class MyThreadFactory implements ThreadFactory {
    private AtomicInteger count = new AtomicInteger(0);
    private final String className = MyThreadFactory.class.getSimpleName();

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(className + this.count.getAndAdd(1));
        System.out.println(String.format("Thread name = %s", thread.getName()));
        return thread;
    }
}
