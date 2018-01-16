package com.gxd.Concurrent;

/**
 * Created by gxdgodgxd on 17/7/10.
 */
public class CountNum implements Runnable{

    private static Integer num = 0;
    private static final Object object = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (num) {
//                num++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " num : " + num++);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new CountNum()).start();
        }
    }
}
