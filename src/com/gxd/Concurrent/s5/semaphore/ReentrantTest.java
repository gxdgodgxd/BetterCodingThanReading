package com.gxd.Concurrent.s5.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gxdgodgxd on 18/1/12.
 */
public class ReentrantTest {

    ReentrantLock lock = new ReentrantLock();
    Semaphore sem = new Semaphore(1);
    A a;
    B b;

    public ReentrantTest() {
        this.a = new A();
        this.b = new B();
    }

    public class A {

        public void a() throws InterruptedException {
//            lock.lock();
            sem.acquire();
            System.out.println("SameTimeEnd");
        }
    }

    public class B {

        public void b() throws InterruptedException {
//            lock.lock();
            sem.acquire();
            System.out.println("b");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantTest rt = new ReentrantTest();
        rt.a.a();
        rt.b.b();
    }

}
