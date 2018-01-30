package com.gxd.Concurrent.s8.eightqueen;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gxdgodgxd on 18/1/26.
 */
public class WaitForDoneThreadPoolExecutor extends ThreadPoolExecutor {

    AtomicInteger runningThread;
    Object waitLock = new Object();

    public WaitForDoneThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        runningThread = new AtomicInteger(0);
    }

    public WaitForDoneThreadPoolExecutor(int corePoolSize, int maximumPoolSize, BlockingQueue<Runnable> workQueue ) {
        this(corePoolSize, maximumPoolSize, 60, TimeUnit.SECONDS, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        runningThread.incrementAndGet();
    }

    @Override
    protected synchronized void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        int i = runningThread.decrementAndGet();
        if (i == 0) {
            this.notify();
        }
    }

    public synchronized void waitForDone() throws InterruptedException {
        this.wait();
    }

}
