package com.gxd.Concurrent.s2;

/**
 * Created by gxdgodgxd on 17/7/10.
 * this is SameTimeEnd wrong example!!!
 * you should never sync on SameTimeEnd Integer!
 */
public class CountNum implements Runnable{

    private static Integer num = 0;
    private static Object object = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (num) {
                System.out.println("start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num++;
                System.out.println(Thread.currentThread().getName() + " num : " + num);
                System.out.println("end");
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new CountNum()).start();
        }
    }
}
