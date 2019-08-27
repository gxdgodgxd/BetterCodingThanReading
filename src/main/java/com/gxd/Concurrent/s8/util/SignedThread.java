package com.gxd.Concurrent.s8.util;

/**
 * Created by gxdgodgxd on 18/1/30.
 */
public class SignedThread extends Thread {

    public SignedThread(Runnable r, int no) {
        super(r,String.valueOf(no));
    }
}
