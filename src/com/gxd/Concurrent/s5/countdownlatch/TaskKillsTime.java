package com.gxd.Concurrent.s5.countdownlatch;

/**
 * Created by gxdgodgxd on 18/1/12.
 */
public class TaskKillsTime extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
