package com.gxd.Concurrent.s5.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by gxdgodgxd on 18/1/12.
 */
public class TestHarness {

    public long timeTasks(int nThreads, final Runnable task) {
        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    try {
                        startGate.await();
                        task.run();
                        endGate.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        try {
            endGate.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        return end - start;

    }

    public static void main(String[] args) {
        TestHarness th = new TestHarness();
        System.out.println(th.timeTasks(3, new TaskKillsTime()));
    }
}
