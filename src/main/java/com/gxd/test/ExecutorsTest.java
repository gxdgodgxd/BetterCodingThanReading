package com.gxd.test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by gxdgodgxd on 17/7/4.
 */
public class ExecutorsTest
{

    public static void main(String[] args) {
        Executor executor = Executors.newScheduledThreadPool(1);
    }
}
