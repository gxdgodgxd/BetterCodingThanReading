package com.gxd.Concurrent;

/**
 * Created by gxdgodgxd on 18/1/16.
 */
public class SynchronizedTest implements Runnable{
//    static Integer count = new Integer(0);
    static Integer lock = new Integer(0);
    private int threadIndex = -1;

    public SynchronizedTest(int threadIndex) {
        this.threadIndex = threadIndex;
    }

    @Override
    public void run() {
//        System.out.println("in");
        for (int i = 0; i < 10; ++i) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (SynchronizedTest.lock) {
//                count++;
                lock++;
//                System.out.println("Thread " + threadIndex + ": " + count);
                System.out.println("Thread " + threadIndex + " lock : " + lock);
            }
        }
//        System.out.println("out");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; ++i) {
            SynchronizedTest threadTest = new SynchronizedTest(i);
            Thread thread = new Thread(threadTest);
            thread.start();
        }
    }
}
