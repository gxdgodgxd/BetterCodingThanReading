package com.gxd.Concurrent.s6.schedule;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by gxdgodgxd on 18/1/15.
 */
public class ScheduledExecutor {


    public static void main(String[] args) throws InterruptedException {
        case1();
//        case2();
    }

    public static void case1() throws InterruptedException {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.schedule(new ThrowTask(), 3, TimeUnit.SECONDS);
        System.out.println("before 1    " + System.nanoTime());
        Thread.sleep(1000);
        System.out.println("after 1     " + System.nanoTime());
        exec.schedule(new ThrowTask(), 10, TimeUnit.SECONDS);
        System.out.println("before 5        " + System.nanoTime());
        Thread.sleep(5000);
        System.out.println("after 5     " + System.nanoTime());
        exec.shutdown();
    }

    public static void case2() throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
        Thread.sleep(1000);
        timer.schedule(new ThrowTask(), 1);
        Thread.sleep(5000);
    }

    public static class ThrowTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("start       " + System.nanoTime());
            throw new RuntimeException();
        }
    }

}
