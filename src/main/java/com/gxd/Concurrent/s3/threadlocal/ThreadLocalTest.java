package com.gxd.Concurrent.s3.threadlocal;

/**
 * Created by gxdgodgxd on 18/1/8.
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> num = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public Integer getNum(){
        num.set(num.get()+1);
        return num.get();
    }

    public static void main(String[] args) {
        ThreadLocalTest t = new ThreadLocalTest();
        Thread t1 = new Thread1(t);
        Thread t2 = new Thread1(t);
        Thread t3 = new Thread1(t);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class Thread1 extends Thread {

        private ThreadLocalTest t;

        public Thread1(ThreadLocalTest t) {
            this.t = t;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(t.getNum());

            }
        }
    }

}
