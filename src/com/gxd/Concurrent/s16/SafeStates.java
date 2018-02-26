package com.gxd.Concurrent.s16;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * Created by gxdgodgxd on 18/2/24.
 */
public class SafeStates {

    private final Map<String, String> map;

    public SafeStates() {
        map = new HashMap<>();
        map.put("abc", "def");
    }

    public String getValue(String str){
        return map.get(str);
    }

    public void setValue(String key, String val) {
        map.put(key, val);
    }

    public static void main(String[] args) {
        SafeStates safeStates = new SafeStates();
        CountDownLatch latch = new CountDownLatch(1);

        abstract class StateThread extends Thread{

            SafeStates safeStates;

            public StateThread(SafeStates safeStates) {
                this.safeStates = safeStates;
            }
        }

        Thread t1 = new StateThread(safeStates) {
            @Override
            public void run() {
                try {
                    latch.await();
                    this.safeStates.setValue("abc","defg");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t2 = new StateThread(safeStates) {
            @Override
            public void run() {
                try {
                    latch.await();
                    System.out.println(this.safeStates.getValue("abc"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        t2.start();

        latch.countDown();
    }
}
