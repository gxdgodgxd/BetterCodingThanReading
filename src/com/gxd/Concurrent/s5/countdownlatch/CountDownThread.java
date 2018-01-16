package com.gxd.Concurrent.s5.countdownlatch;

/**
 * Created by gxdgodgxd on 18/1/4.
 */
public class CountDownThread implements Runnable{

    Counter counter;

    public CountDownThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run () {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
//                System.out.println(System.nanoTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(counter.countDown());
        }
    }
}
