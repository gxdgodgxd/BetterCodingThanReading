package com.gxd.Concurrent.s3;

/**
 * Created by gxdgodgxd on 17/7/13.
 */
public class NoVisibility{

    private static boolean ready = false;
    private static int number;

    private static class ReadThread extends Thread{
        @Override
        public void run() {
            while (!ready) {
                //yield和flush都可以影响JIT进行代码优化,ready的值会循环去读,而非只读一次
//                Thread.yield();
//                System.out.flush();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReadThread().start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number = 2;
        ready = true;
    }

}
