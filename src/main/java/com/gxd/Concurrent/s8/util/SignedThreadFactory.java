package com.gxd.Concurrent.s8.util;

import java.util.concurrent.ThreadFactory;

/**
 * Created by gxdgodgxd on 18/1/30.
 */
public class SignedThreadFactory implements ThreadFactory{

    private int count;

    public SignedThreadFactory() {
        count = 0;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new SignedThread(r,count++);
    }
}
