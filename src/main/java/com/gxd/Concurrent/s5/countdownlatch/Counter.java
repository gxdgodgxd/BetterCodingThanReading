package com.gxd.Concurrent.s5.countdownlatch;

/**
 * Created by gxdgodgxd on 18/1/4.
 */
public class Counter {

    int count;

    public Counter(int count) {
        this.count = count;
    }

    public synchronized int countDown() {
        this.count--;
        if (this.count==0){
            this.notifyAll();
//            this.notify();
        }
        return this.count;
    }

    public synchronized void await() throws InterruptedException {
        if (this.count != 0) {
            System.out.println(Thread.currentThread().getName() + " is waiting");
            this.wait();
        }
    }
}
