package com.gxd.Concurrent.s5.countdownlatch;

/**
 * Created by gxdgodgxd on 18/1/4.
 */
public class CounterTest {

    public static void main(String[] args) {
        Counter counter = new Counter(5);

        Thread thread = new Thread(new CountDownThread(counter));
        thread.start();
//        Thread thread2 = new Thread(new CountDownThread(counter));
//        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    counter.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 3 awake");
            }
        });
        thread3.start();

        try {
            counter.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main awake");

    }

}
