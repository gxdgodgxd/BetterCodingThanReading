package com.gxd.Concurrent.s10;

/**
 * Created by gxdgodgxd on 18/2/1.
 */
public class DeadLock {
    // TODO: 18/2/1 写个死锁 并thread dump观察死锁
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println("t1 got them both!");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println("t2 got them both!");
                    }
                }
            }
        });

        t1.start();
        t2.start();

    }
}
