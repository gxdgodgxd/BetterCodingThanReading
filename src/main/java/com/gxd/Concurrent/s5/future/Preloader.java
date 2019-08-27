package com.gxd.Concurrent.s5.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by gxdgodgxd on 18/1/12.
 */
public class Preloader {

    private final FutureTask<Integer> future = new FutureTask<Integer>(new Callable<Integer>() {
        @Override
        public Integer call() throws InterruptedException {
            Thread.sleep(3000);
            return 3;
        }
    });

    private final Thread t = new Thread(future);

    public void start(){
        t.start();
    }

    public Integer get() throws InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            throw launderThrowable(cause);
        }
    }

    public static RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException) {
            return (RuntimeException)t;
        } else if (t instanceof Error) {
            throw (Error)t;
        }else {
            throw new IllegalStateException("not unchecked", t);
        }
    }

    public static void main(String[] args) {
        Preloader p = new Preloader();
        p.start();
        System.out.println("start");
        try {
            System.out.println("get " + p.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
