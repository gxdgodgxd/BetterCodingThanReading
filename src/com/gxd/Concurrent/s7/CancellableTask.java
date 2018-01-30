package com.gxd.Concurrent.s7;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/**
 * Created by gxdgodgxd on 18/1/19.
 */
public interface CancellableTask<T> extends Callable<T> {
    void cancel();
    RunnableFuture<T> newTask();
}
