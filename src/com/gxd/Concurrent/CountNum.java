package com.gxd.Concurrent;

/**
 * Created by gxdgodgxd on 17/7/10.
 */
public class CountNum implements Runnable{

    private static Integer num = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (num) {
                System.out.println(Thread.currentThread().getName() + " num : " + num++);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new CountNum()).start();
        }
    }
}
