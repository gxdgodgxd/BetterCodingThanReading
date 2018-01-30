package com.gxd.Concurrent.s8;

import com.gxd.Concurrent.s5.countdownlatch.TaskKillsTime;
import com.gxd.Concurrent.s8.eightqueen.WaitForDoneThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by gxdgodgxd on 18/1/26.
 */
public class MainThreadFinish {

    ExecutorService exec = new WaitForDoneThreadPoolExecutor(0,3,5, TimeUnit.SECONDS,new SynchronousQueue<>());

    public static void main(String[] args) {
        MainThreadFinish main = new MainThreadFinish();
        main.exec.execute(new TaskKillsTime());
        System.out.println(1);
    }
}
