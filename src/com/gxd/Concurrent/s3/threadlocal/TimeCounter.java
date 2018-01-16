package com.gxd.Concurrent.s3.threadlocal;

/**
 * Created by gxdgodgxd on 17/7/18.
 */
public class TimeCounter {

    private static final ThreadLocal<Long> timeHolder = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static void begin(){
        timeHolder.set(System.currentTimeMillis());
    }

    public static Long end(){
        return System.currentTimeMillis() - timeHolder.get();
    }

    public static class OtherThread extends Thread{

        @Override
        public void run() {
            TimeCounter.begin();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("time cost : " + TimeCounter.end());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TimeCounter.begin();
        new OtherThread().start();
        Thread.sleep(1000);
        System.out.println("time cost : " + TimeCounter.end());

    }
}
