package com.gxd.Concurrent.s5.barrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by gxdgodgxd on 18/1/15.
 */
public class LeftCycleRightRect {

    private final CyclicBarrier barrier;
    private final Worker[] workers;

    public LeftCycleRightRect() {
        Random r = new Random();
        this.barrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "is done! waiting for next round");
                System.out.println("-----------------------------------");
            }
        });
        workers = new Worker[2];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker(r);
        }
    }

    public void start(){
        for (int i = 0; i < workers.length; i++) {
            new Thread(workers[i]).start();
        }
    }

    public class Worker implements Runnable{

        long t;
        Random r;

        public Worker(Random r) {
            this.r = r;
        }

        @Override
        public void run() {
            while (true){
                t = (long)r.nextInt(1000);
                try {
                    Thread.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " sleep " + t);
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        LeftCycleRightRect l = new LeftCycleRightRect();
        l.start();
    }


}

