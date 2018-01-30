package com.gxd.Concurrent.s8.SameTimeEnd;

import com.gxd.Concurrent.s8.util.SignedThreadFactory;

import java.util.concurrent.*;

/**
 * Created by gxdgodgxd on 18/1/30.
 */
public class SameTimeEnd {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+" waiting");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName()+" finish waiting");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        };
        ExecutorService es = new ThreadPoolExecutor(10, 10, 5, TimeUnit.SECONDS, new SynchronousQueue<>(), new SignedThreadFactory()){

        };
        for (int i = 0; i < 10; i++) {
            es.execute(runnable);
        }
    }
}
